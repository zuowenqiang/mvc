package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.web.entity.User;

import com.web.util.DBUtil;

public class look extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String sql ="select*from tb_user where  uid=？";
		List<Object[]> list =DBUtil.executeQurry(sql,new Object[]{uid});
		Object[] os = list.get(0);
		User user =new User((Integer)os[0],(String)os[1],(String)os[2],(String)os[3],(Integer)os[4],(Integer)os[5],(String)os[6],(String)os[7]);
		req.getSession().setAttribute("User", user);
		req.getRequestDispatcher("view/look.jsp").forward(req, resp);
	}
    
}
