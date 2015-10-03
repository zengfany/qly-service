package com.qly.dao.impl.mybatis;

import com.qly.dao.IUserDao;
import com.qly.dao.impl.mybatis.mapper.UserMapper;
import com.qly.model.User;

import javax.inject.Inject;


/**
 * Created by Fanyi on 15/10/2.
 */
public class UserDaoImpl implements IUserDao {

    @Inject
    private UserMapper userMapper;

    public User getUserById(Long userId){
        System.out.println("UserDaoImpl get called with userId: " + userId);
        User user = this.userMapper.getUserById(userId);
        return user;
    }
}
