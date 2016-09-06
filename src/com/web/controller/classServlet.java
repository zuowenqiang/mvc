package com.web.controller;
 
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.util.DBUtil;

public class classServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		   throws ServletException, IOException {
           String sql="select*from class order by time desc";
           List<Object[]> list = DBUtil.executeQurry(sql, null);
           req.setAttribute("classList", list);
           req.setAttribute("date", new Date());
           req.getRequestDispatcher("view/class.jsp").forward(req,resp);
	}
    
}
