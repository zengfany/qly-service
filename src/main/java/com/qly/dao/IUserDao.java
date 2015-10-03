package com.qly.dao;


import com.qly.model.User;

/**
 * 会员信息Dao
 * @author admin
 *
 */
public interface IUserDao {

	User getUserById(Long userId);

	
}
