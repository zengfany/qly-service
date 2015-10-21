package com.qly.service.api.v1;

import com.google.inject.Inject;
import com.qly.dao.IGoodsDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fanyi on 15/10/21.
 */
@Path("/api/v1/goods")
public class GoodsResource {

    @Inject
    private IGoodsDao goodsDao;

    @GET
    @Path("/{goods_id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public HashMap<String, Object> getGoodDetail(@PathParam("goods_id") Long goods_id, @QueryParam("user_id") Long user_id) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> comboGoods;
        try {
            comboGoods = goodsDao.getComboGoodsByGoodsId(user_id, goods_id);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", -1);
            response.put("errmsg", e.getMessage());
            return response;
        }

        response.put("status", 0);
        response.put("goods", comboGoods);

        return response;
    }
}
