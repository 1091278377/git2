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
import com.luoxc.serviceImp.AaaServiceImp;


@WebServlet("/chaxun")
public class chaxun extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public chaxun() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page1 = request.getParameter("page1");
		
		int pages =0;
		
		if(page1!=null) pages = Integer.parseInt(page1);
		
		response.setContentType("text/html;charset=utf-8");
		try {
		   AaaServiceImp aaaserviceimp  = new AaaServiceImp();
		  List<Aaa> list=
				aaaserviceimp.queryGoods3(pages);
		   System.out.println(JSON.toJSONString(list));
		  Map<String,Object> map =new HashMap<String,Object>();
		  if(list != null && list.size()>0) {
			map.put("flag","true");
		}else {
			map.put("flag","false");
		}
		map.put("data", list);
		PrintWriter writer = response.getWriter();
		writer.write(JSON.toJSONString(map));
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
