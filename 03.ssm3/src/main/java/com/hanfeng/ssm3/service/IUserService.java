package com.hanfeng.ssm3.service;

import com.hanfeng.ssm3.model.User;

/** 
 * @author hanfeng E-mail:zhdevelop@gmail.com 
 * @version 2013年11月26日 上午11:57:48 
 * 
 */

public interface IUserService {
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return
	 */
	public User getUserById(long id);
}
