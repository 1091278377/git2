package com.luoxc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.luoxc.pojo.Aaa;
import com.luoxc.serviceImp.AaaServiceImp;

/**
 * Servlet implementation class Tianjia
 */
@WebServlet("/Tianjia")
public class Tianjia extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Tianjia() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AaaServiceImp aaaServiceImp = new  AaaServiceImp();
		String id1 =request.getParameter("id");
		int id2 = Integer.parseInt(id1);
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		String type1=request.getParameter("type");
		Aaa aaa=new Aaa(id2,username1,password1,type1);
		boolean b= aaaServiceImp.addGoods(aaa);
        //if(b) {		
			//response.sendRedirect("/CRM/zhuye.html");
		//}else {
			//PrintWriter writer = response.getWriter();
			//writer.write("<pan>Œ“ «Ã«¥∞</pan>");
			response.getWriter().write(JSON.toJSONString(b));
			//alert("id¥ÌŒÛ");
			//response.sendRedirect("/CRM/add.html");
		
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
