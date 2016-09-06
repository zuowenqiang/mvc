package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

public class Student extends HttpServlet{


	public Student(){
		System.out.println("TestServlet创建对象");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("TestServlet无参数！");
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TestServlet有参数");
		super.init(config);
	}

	@Override
	public void destroy() {
		System.out.println("TestServlet对象销毁");
		super.destroy();
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
	    req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");//名字
		String sex =req.getParameter("sex");//性别
		String time =req.getParameter("time");//入学时间
		String deptid =req.getParameter("deptid");//班级
		
		
		String sql = "select*from stuinfo where sid = ?";
		HttpSession session = req.getSession();
		List<Object[]> list =DBUtil.executeQurry(sql,new Object[]{name});
		if(list.size()>0){
			//查看有木有这个学生
			req.setAttribute("Error", "已经有这学生了");
			req.getRequestDispatcher("StudentsReg.jsp").forward(req, resp);//请求派发
		}else{
			req.setAttribute("Error", "插入成功");
			//可以注册，执行insert语句
			String sql1="insert into stuinfo(name,sex,time,deptid) values(?,?,?,?)";
			DBUtil.executeDML(sql1, new Object[]{name,sex,time,deptid});
			//resp.sendRedirect("index.jsp");
			req.getRequestDispatcher("student").forward(req, resp);
		}
	}
    
}
