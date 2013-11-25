package com.hanfeng.mybatis.model;

import java.util.List;

/** 
 * @author hanfeng E-mail:zhdevelop@gmail.com 
 * @version 2013年11月25日 下午1:21:18 
 * 
 */

public interface IUser {
	/**
	 * 通过id来查询用户
	 */
	public User selectUserById(int id);
	/**
	 * 查询用户列表
	 */
	public List<User> selectUserList();
	/**
	 * 增加用户
	 */
	public void addUser(User user);
	/**
	 * 更新用户
	 */
	public void updateUser(User user);
	/**
	 * 删除用户
	 * 
	 */
	public void deleteUser(int id);
}
