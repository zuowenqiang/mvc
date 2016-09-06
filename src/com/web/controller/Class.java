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
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.web.util.DBUtil;

public class Class extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
	    req.setCharacterEncoding("utf-8");
		String name = req.getParameter("cname");//班级名称
		String time =req.getParameter("time");//加班时间
		
		String sql = "select*from class where cid = ? ";
		System.out.println(name);
		HttpSession session = req.getSession();
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{name});
		if(list.size()>0){
			//查看有木有这个班级
			session.setAttribute("classError", "此班级已存在！请重新添加！");
			resp.sendRedirect("ClassReg.jsp");
		}else{
			req.setAttribute("date", new Date());
			   String sql1 = "insert into class(cname,time) values(?,?)";
						
				 DBUtil.executeDML(sql1, new Object[]{name,time});
				 //resp.sendRedirect("class");
				 req.getRequestDispatcher("class").forward(req, resp);
			
		}	
	}
    
}
