package com.luoxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luoxc.pojo.Aaa;
import com.luoxc.serviceImp.AaaServiceImp;


@WebServlet("/Zhuche")
public class Zhuche extends HttpServlet {
	AaaServiceImp aaaServiceImp = new  AaaServiceImp();
  
    public Zhuche() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 =request.getParameter("id");
		int id2 = Integer.parseInt(id1);
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		String type1=request.getParameter("type");
		Aaa aaa=new Aaa(id2,username1,password1,type1);
		boolean b= aaaServiceImp.addGoods(aaa);
        if(b) {		
			response.sendRedirect("/CRM/login.html");
		}else {
			response.sendRedirect("/CRM/zhuche.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
