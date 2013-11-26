package com.hanfeng.ssm3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.hanfeng.ssm3.model.User;
import com.hanfeng.ssm3.service.IUserService;

/** 
 * @author hanfeng E-mail:zhdevelop@gmail.com 
 * @version 2013年11月26日 下午12:30:41 
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	private IUserService userService;
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/index/{id}")
	public String showUser(@PathVariable int id,HttpServletRequest request){
		User u = userService.getUserById(id);
		request.setAttribute("user", JSON.toJSONString(u));
		return "index";
		
	}
}
