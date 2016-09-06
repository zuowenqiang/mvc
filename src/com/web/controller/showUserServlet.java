package com.web.controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.web.util.DBUtil;

public class showUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
           String sql="select*from tb_user";
           List<Object[]> list = DBUtil.executeQurry(sql, null);
           req.setAttribute("useList", list);
           req.setAttribute("date", new Date());
           req.getRequestDispatcher("view/showUser.jsp").forward(req,resp);
	}
    
}
