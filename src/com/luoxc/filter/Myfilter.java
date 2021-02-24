package com.luoxc.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.alibaba.fastjson.JSON;

public class Myfilter implements Filter {
	
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
	    response.setHeader("Access-Control-Max-Age","3600");
	    response.setHeader("Access-Control-Allow-Header","x-requested-with");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    
	    String userid = request.getHeader("userid");
	    if(userid !=null &&userid!="") {
	    	filter.doFilter(req, res);
	    }else {
	    	PrintWriter writer=response.getWriter();
	    	Map<String,Object> map = new HashMap<String,Object>();
			map.put("flag", "false");
			response.getWriter().write(JSON.toJSONString(map));
	    }
	}


}
