package com.luoxc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.luoxc.pojo.Aaa;
import com.luoxc.pojo.Commodity;
import com.luoxc.serviceImp.CommoServiceImp;



@WebServlet("/co_chaxun")
public class co_chaxun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public co_chaxun() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page1 = request.getParameter("page1");		
		int pages =0;		
		if(page1!=null) pages = Integer.parseInt(page1);		
		response.setContentType("text/html;charset=utf-8");
		
		   CommoServiceImp commoserviceimp  = new CommoServiceImp();
		  Commodity list=
				commoserviceimp.queryGoods(pages);
		   //System.out.println(JSON.toJSONString(list));
	
		
		PrintWriter writer = response.getWriter();
		writer.write(JSON.toJSONString(list));
	
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
