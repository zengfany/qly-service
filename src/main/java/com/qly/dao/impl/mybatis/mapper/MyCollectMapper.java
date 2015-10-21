package com.qly.dao.impl.mybatis.mapper;

import com.qly.model.MyCollect;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Fanyi on 15/10/21.
 */
public interface MyCollectMapper {

    @Select("select * from bk_my_collect bmc where bmc.user_id = #{user_id} and bmc.goods_id = #{goods_id}")
    MyCollect getMyCollectByUserIdAndGoodsId(@Param("user_id")Long user_id, @Param("goods_id")Long goods_id);
}
