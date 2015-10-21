package com.qly.service.api.v1;

import com.google.inject.Inject;
import com.qly.dao.IVenderDao;
import com.qly.model.Vender;
import com.qly.util.DistanceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * Created by Fanyi on 15/10/21.
 */
@Path("/api/v1/venders")
public class VenderResource {

    @Inject
    private IVenderDao venderDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public HashMap<String, Object> getVenders(
                                   @QueryParam("city") @DefaultValue("") String city,
                                   @QueryParam("region") @DefaultValue("") String region,
                                   @QueryParam("category") @DefaultValue("0") int category_id,
                                   @QueryParam("lat") @DefaultValue("0.0") double lat,
                                   @QueryParam("lng") @DefaultValue("0.0") double lng,
                                   @QueryParam("sort") @DefaultValue("distance") String sort,
                                   @QueryParam("page") @DefaultValue("0") int page,
                                   @QueryParam("page_size") @DefaultValue("10") int page_size) {

        Logger logger = LoggerFactory.getLogger(VenderResource.class.getName());

        logger.info("receive get venders request");

        HashMap<String, Object> response = new HashMap<String, Object>();

        if (city.equals("")) {
            response.put("status", -1);
            response.put("errmsg", "no city id");
            return response;
        }

        List<Vender> retVenders;
        if (region.length() > 0 && category_id != 0) {
            retVenders = venderDao.getVendersByRegionAndCategory(region, category_id, sort);

        } else if (region.length() > 0) {
            retVenders = venderDao.getVendersByRegion(region, sort);

        } else if (category_id != 0) {
            retVenders = venderDao.getVendersByCategory(category_id, sort);

        } else {
            retVenders = venderDao.getVendersByAll(sort);
        }

        if (sort.equals("distance") && lat > 0 && lng > 0) {
            logger.info("sort venders by distance");
            for (Vender v : retVenders) {
                double myDis = 1000000000 ;
                if(v.getMap_lat() != null && v.getMap_lat()>0
                        && v.getMap_lng()!=null && v.getMap_lng()>0){
                    myDis = DistanceUtil.getDistance(lat, lng, v.getMap_lat(), v.getMap_lng());
                    v.setDistance_mi(myDis);
                }
            }

            //sort all the elements in retVenders by myDis, not good idea
            Collections.sort(retVenders, new Comparator<Vender>() {
                public int compare(Vender v1, Vender v2) {
                    double k1 = v1.getDistance_mi() == null ? 1000000000.0 : v1.getDistance_mi();
                    double k2 = v2.getDistance_mi() == null ? 1000000000.0 : v2.getDistance_mi();
                    if (k1 == k2) {
                        return 0;
                    } else if (k1 > k2) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }

        List<Vender> respVenders = retVenders.subList(page * page_size,
                                                      Math.min(page * page_size + page_size, retVenders.size()));
        response.put("status", 0);
        response.put("page", page);
        response.put("size", respVenders.size());
        response.put("data", respVenders);

        return response;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public HashMap<String, Object> getVender(@PathParam("id") Long id) {
        Logger logger = LoggerFactory.getLogger(VenderResource.class.getName());

        logger.info("receive get single vender request: " + id);
        HashMap<String, Object> response = new HashMap<String, Object>();

        Map<String, Object> retVender = venderDao.getComboVenderById(id);

        response.put("status", 0);
        response.put("data", retVender);

        return response;
    }
}
