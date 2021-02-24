package com.luoxc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.luoxc.serviceImp.AaaServiceImp;

 
@WebServlet("/User")
public class User extends HttpServlet {
     AaaServiceImp aaaServiceImp = new  AaaServiceImp();

    public User() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		boolean b=aaaServiceImp.queryGoods2(username1,password1);
		//response.setContentType("text/javascript;charset=utf-8");
		if(b) {
			
				String sessionid = request.getSession().getId();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("id", sessionid);
				map.put("denglu", b);
				response.getWriter().write(JSON.toJSONString(map));
			}else {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("id", 0);
				map.put("denglu", false);
				response.getWriter().write(JSON.toJSONString(map));	
			}
		//System.out.println(b);
		//if(b) {
			
			//response.sendRedirect("/CRM/zhuye.html");
		//}else {
			//response.sendRedirect("/CRM/login.html");
		//}
		//response.getWriter().write(JSON.toJSONString(b));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
