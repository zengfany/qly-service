package com.qly.dao.impl.mybatis.mapper;

import com.qly.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Fanyi on 15/10/21.
 */
public interface GoodsMapper {
    @Select("select  bg.* from bk_vender_goods bvg left join bk_goods  bg on bvg.goods_id = bg.goods_id " +
            "where bvg.vender_id = #{vender_id} " +
            "   and bg.del_flag = 1 " +
            "   and bg.is_on_sale = 1"
    )
    List<Goods> findTicketGoodsByVenderId(@Param("vender_id") Long vender_id);

    @Select("SELECT " +
            "    bg.*, " +
            "    (select count(1) from bk_virtual_card svc left join bk_order_goods sog " +
            "            on svc.order_goods_id = sog.order_goods_id where sog.goods_id = bg.goods_id) as sales " +
            "FROM " +
            "     bk_goods AS bg " +
            "WHERE " +
                  "bg.del_flag = 1 and " +
                  "bg.goods_id = #{goods_id}"
    )
    Goods findGoodsByGoodsId(@Param("goods_id") Long goods_id);

    @Select("select vender_id from bk_vender_goods where goods_id = #{goods_id}")
    Long findVenderIdByGoodsId(@Param("goods_id") Long goods_id);

    

}
