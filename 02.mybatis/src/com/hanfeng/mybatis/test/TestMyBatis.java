package com.hanfeng.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.hanfeng.mybatis.model.IUser;
import com.hanfeng.mybatis.model.User;

/** 
 * @author hanfeng E-mail:zhdevelop@gmail.com 
 * @version 2013年11月25日 上午11:59:18 
 * 
 */

public class TestMyBatis{
	/**
	 * MyBatis应用是以一个SqlSessionFactory对象的实例为核心，
	 * 该对象的实例可以通过SqlSessionFactoryBulider对象获得。
	 * 
	 */
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader; 
	  
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	@Before
	public void before(){
		  try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
         
	}
	@Test
	public void test1(){
		//获取SqlSession实例，SqlSession对象完全包含以数据库为背景的所有执行sql操作的方法。
		//我们可以用 SqlSession实例来直接执行已映射的 SQL语句
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			User user = (User)session.selectOne("com.hanfeng.mybatis.model.User.selectUserById",1);
			IUser iUser = session.getMapper(IUser.class);
			User user = iUser.selectUserById(1);
			System.out.println(JSON.toJSONString(user));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	@Test
	public void test2(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUser iUser = session.getMapper(IUser.class);
			List<User> users = iUser.selectUserList();
			System.out.println("获取用户列表："+JSON.toJSONString(users));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	@Test
	public void testAddUser(){
		User u1 = new User();
		u1.setAccount("zhaoqi");
		u1.setPassword("123");
		u1.setName("赵琦");
		u1.setAge(30);
		u1.setAddress("福建省龙岩市");
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUser iUser = session.getMapper(IUser.class);
			iUser.addUser(u1);
			session.commit(); //提交事务
			System.out.println("新增用户："+JSON.toJSONString(u1));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	@Test
	public void testUpdateUser(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUser iUser = session.getMapper(IUser.class);
			User user = iUser.selectUserById(5);
			user.setName("赵七");
			iUser.updateUser(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	@Test
	public void testDeleteUser(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUser iUser = session.getMapper(IUser.class);
			iUser.deleteUser(5);
			session.commit();
			System.err.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
