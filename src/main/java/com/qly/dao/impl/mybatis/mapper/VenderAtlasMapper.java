package com.qly.dao.impl.mybatis.mapper;

import com.qly.model.VenderAtlas;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Fanyi on 15/10/21.
 */
public interface VenderAtlasMapper {

    @Select("select vender_atlas_id, vender_id, img_path, del_flag " +
            "from bk_vender_atlas bva " +
            "where bva.del_flag = 1 and bva.vender_id = #{vender_id} " +
            "order by bva.add_time desc"
    )
    List<VenderAtlas> getVenderAtlasByVenderId(@Param("vender_id") Long vender_id);
}
