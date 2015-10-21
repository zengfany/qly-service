package com.qly.dao.impl.mybatis.mapper;

import com.qly.model.Vender;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Fanyi on 15/10/21.
 */
public interface VenderMapper {

    @Select("SELECT bbv.*" +
            " FROM" +
                " bk_vender bbv right join (" +
                    " select bvg.vender_id ,count(*) as goods_count from bk_goods bg right join bk_vender_goods  bvg on bg.goods_id = bvg.goods_id" +
                    " where bg.is_on_sale = 1 and bg.del_flag = 1  group by bvg.vender_id" +
                " ) vv on vv.vender_id = bbv.vender_id" +
            " where" +
            " del_flag = 1" +
            " and bbv.category_id = #{category_id}" +
            " and bbv.region = #{region}" +
            " order by  (ifnull(threshold_1,0)+ifnull(threshold_2,0)+ifnull(threshold_3,0)) desc"
    )
    List<Vender> getVendersByRegionAndCategory(@Param("region") String region, @Param("category_id") int category_id, String sort);


    @Select(" SELECT bbv.*" +
            " FROM" +
            " bk_vender bbv right join (" +
            " select bvg.vender_id ,count(*) as goods_count from bk_goods bg right join bk_vender_goods  bvg on bg.goods_id = bvg.goods_id" +
            " where bg.is_on_sale = 1 and bg.del_flag = 1  group by bvg.vender_id" +
            " ) vv on vv.vender_id = bbv.vender_id" +
            " where" +
            " del_flag = 1" +
            " and bbv.region = #{region}" +
            " order by  (ifnull(threshold_1,0)+ifnull(threshold_2,0)+ifnull(threshold_3,0)) desc"
    )
    List<Vender> getVendersByRegion(@Param("region") String region, String sort);


    @Select(" SELECT bbv.*" +
            " FROM" +
            " bk_vender bbv right join (" +
            " select bvg.vender_id ,count(*) as goods_count from bk_goods bg right join bk_vender_goods  bvg on bg.goods_id = bvg.goods_id" +
            " where bg.is_on_sale = 1 and bg.del_flag = 1  group by bvg.vender_id" +
            " ) vv on vv.vender_id = bbv.vender_id" +
            " where" +
            " del_flag = 1" +
            " and bbv.category_id = #{category_id}" +
            " order by  (ifnull(threshold_1,0)+ifnull(threshold_2,0)+ifnull(threshold_3,0)) desc"
    )
    List<Vender> getVendersByCategory(@Param("category_id") int category_id, String sort);

    @Select(" SELECT bbv.*" +
            " FROM" +
            " bk_vender bbv right join (" +
            " select bvg.vender_id ,count(*) as goods_count from bk_goods bg right join bk_vender_goods  bvg on bg.goods_id = bvg.goods_id" +
            " where bg.is_on_sale = 1 and bg.del_flag = 1  group by bvg.vender_id" +
            " ) vv on vv.vender_id = bbv.vender_id" +
            " where" +
            " del_flag = 1" +
            " order by  (ifnull(threshold_1,0)+ifnull(threshold_2,0)+ifnull(threshold_3,0)) desc"
    )
    List<Vender> getVendersByAll(String sort);

    @Select(" SELECT *" +
            " FROM " +
            "   bk_vender " +
            " where " +
            "   del_flag = 1 " +
            "   and vender_id = #{id}"
    )
    Vender getVenderById(@Param("id") Long id);
}
