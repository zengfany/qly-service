package com.qly.dao;

import com.qly.model.Goods;
import com.qly.model.Vender;

import java.util.Map;

/**
 * Created by Fanyi on 15/10/21.
 */
public interface IGoodsDao {
    public Goods getGoodsByGoodsId(Long id);
    public Vender getVenderByGoodsId(Long id);
    public Integer getGoodsColletStatus(Long user_id, Long goods_id);
    Map<String, Object> getComboGoodsByGoodsId(Long user_id, Long goods_id);
}
