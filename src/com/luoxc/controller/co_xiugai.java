package com.luoxc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.luoxc.pojo.Aaa;
import com.luoxc.pojo.Commodity;
import com.luoxc.serviceImp.CommoServiceImp;



@WebServlet("/co_xiugai")
public class co_xiugai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public co_xiugai() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommoServiceImp commoServiceImp = new CommoServiceImp();
		String id1 =request.getParameter("id");
		int id2 = Integer.parseInt(id1);
		String username1 = request.getParameter("aaa");	
		String password1 = request.getParameter("password");
		double password2 = Double.parseDouble(password1);
		String type1=request.getParameter("type");
		int type2=Integer.parseInt(type1);
		String date1=request.getParameter("date");
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Date date2=null;
		try {
			date2 = sim.parse(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Commodity ccc=new Commodity(id2,username1,password2,type2,date2);
		//System.out.println(JSON.toJSONString(ccc));
		boolean b= commoServiceImp.updaGoods(ccc);
        response.getWriter().write(JSON.toJSONString(b));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
