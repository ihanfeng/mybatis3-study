package com.hanfeng.ssm3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanfeng.ssm3.dao.UserMapper;
import com.hanfeng.ssm3.model.User;
import com.hanfeng.ssm3.service.IUserService;

/**
 * @author hanfeng E-mail:zhdevelop@gmail.com
 * @version 2013年11月26日 上午11:59:11
 * 
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	private UserMapper userMapper;
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public User getUserById(long id) {
	
		return userMapper.selectByPrimaryKey(id);
	}

}
