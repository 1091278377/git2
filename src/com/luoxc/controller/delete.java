package com.luoxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.luoxc.pojo.Aaa;
import com.luoxc.serviceImp.AaaServiceImp;


@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AaaServiceImp aaaServiceImp = new  AaaServiceImp();
		String id1 =request.getParameter("id");
		System.out.println(id1);
		int id2 = Integer.parseInt(id1);
	
		
		boolean b= aaaServiceImp.deleGoods(id2);
        //if(b) {		
			//response.sendRedirect("/CRM/zhuye.html");
		//}else {
			//response.sendRedirect("/CRM/delete.html");
		//}
		//response.getWriter().write(JSON.toJSONString(b));
		response.getWriter().write(JSON.toJSONString(b));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
