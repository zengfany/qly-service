package com.qly.dao.impl.mybatis;

import com.qly.dao.IGoodsDao;
import com.qly.dao.impl.mybatis.mapper.GoodsMapper;
import com.qly.dao.impl.mybatis.mapper.MyCollectMapper;
import com.qly.dao.impl.mybatis.mapper.VenderMapper;
import com.qly.model.Goods;
import com.qly.model.MyCollect;
import com.qly.model.Vender;
import org.mybatis.guice.transactional.Transactional;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fanyi on 15/10/21.
 */
public class GoodsDaoImpl implements IGoodsDao {

    @Inject
    private GoodsMapper goodsMapper;
    @Inject
    private VenderMapper venderMapper;
    @Inject
    private MyCollectMapper myCollectMapper;

    @Transactional
    public Goods getGoodsByGoodsId(Long id) {
        return this.goodsMapper.findGoodsByGoodsId(id);
    }
    @Transactional
    public Vender getVenderByGoodsId(Long id) {
        Long vender_id = this.goodsMapper.findVenderIdByGoodsId(id);
        return this.venderMapper.getVenderById(vender_id);
    }
    @Transactional
    public Integer getGoodsColletStatus(Long user_id, Long goods_id) {
        MyCollect mc = this.myCollectMapper.getMyCollectByUserIdAndGoodsId(user_id, goods_id);
        return mc.getCollect_state();
    }

    @Transactional
    public Map<String, Object> getComboGoodsByGoodsId(Long user_id, Long goods_id) {
        Goods goods = this.goodsMapper.findGoodsByGoodsId(goods_id);
        Long vender_id = this.goodsMapper.findVenderIdByGoodsId(goods_id);
        Vender vender = this.venderMapper.getVenderById(vender_id);
        MyCollect mc = null;
        if (user_id != null) {
            mc = this.myCollectMapper.getMyCollectByUserIdAndGoodsId(user_id, goods_id);
        }

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("goods", goods);
        response.put("goods_desc_len", goods.getGoods_desc().length());
        response.put("vender", vender);
        if (mc != null) {
            response.put("collect_status", mc.getCollect_state());
        }
        return response;

    }
}
