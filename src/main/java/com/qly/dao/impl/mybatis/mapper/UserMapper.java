package com.qly.dao.impl.mybatis.mapper;

import com.qly.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Fanyi on 15/10/2.
 */
public interface UserMapper {
    @Select("select * from bk_users where user_id = #{user_id}")
    User getUserById(@Param("user_id") Long id);

}
