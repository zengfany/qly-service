package com.qly.dao.impl.mybatis;

import com.qly.dao.IVenderDao;
import com.qly.dao.impl.mybatis.mapper.GoodsMapper;
import com.qly.dao.impl.mybatis.mapper.VenderAtlasMapper;
import com.qly.dao.impl.mybatis.mapper.VenderMapper;
import com.qly.model.Goods;
import com.qly.model.Vender;
import com.qly.model.VenderAtlas;
import org.mybatis.guice.transactional.Transactional;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fanyi on 15/10/21.
 */
public class VenderDaoImpl implements IVenderDao{
    @Inject
    private VenderMapper venderMapper;
    @Inject
    private VenderAtlasMapper venderAtlasMapper;
    @Inject
    private GoodsMapper goodsMapper;

    @Transactional
    public List<Vender> getVendersByRegionAndCategory(String region, int category_id, String sort) {
        return this.venderMapper.getVendersByRegionAndCategory(region, category_id, sort);
    }

    @Transactional
    public List<Vender> getVendersByRegion(String region, String sort) {
        return this.venderMapper.getVendersByRegion(region, sort);
    }

    @Transactional
    public List<Vender> getVendersByCategory(int category_id, String sort) {
        return this.venderMapper.getVendersByCategory(category_id, sort);
    }

    @Transactional
    public List<Vender> getVendersByAll(String sort) {
        return this.venderMapper.getVendersByAll(sort);
    }

    @Transactional
    public Map<String, Object> getComboVenderById(Long id) {
        Vender vender = this.venderMapper.getVenderById(id);
        List<VenderAtlas> venderImages = this.venderAtlasMapper.getVenderAtlasByVenderId(id);
        List<Goods> goods = this.goodsMapper.findTicketGoodsByVenderId(id);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("vender", vender);
        response.put("vender_images", venderImages);
        response.put("vender_goods", goods);
        return response;
    }
}
