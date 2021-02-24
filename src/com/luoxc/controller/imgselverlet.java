package com.luoxc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class imgselverlet
 */

public class imgselverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public imgselverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		try { 
		boolean ismultipart = ServletFileUpload.isMultipartContent(request);
		if(ismultipart) {
			 FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload= new ServletFileUpload(factory);
			
			List<FileItem> items = upload.parseRequest(request);
		    }	
		} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
