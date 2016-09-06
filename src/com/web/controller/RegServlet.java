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
import javax.xml.ws.Response;

import com.web.util.DBUtil;

public class RegServlet extends HttpServlet{


	public RegServlet(){
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
		String userName = req.getParameter("userName");//账号
		String userpass =req.getParameter("userpass");//密码
		String myForm =req.getParameter("myForm");//邮箱
		String sex =req.getParameter("sex");//性别
		String education =req.getParameter("education");//学历
		String[] hobbys =req.getParameterValues("hobby");//爱好
		String hobby="";
		if(null!=hobbys && hobbys.length>0){
			for(String s:hobbys){
				hobby+=s+",";
			}
		}
		if(hobby.endsWith(","))hobby=hobby.substring(0, hobby.length()-1);
		String introduce =req.getParameter("introduce");//自我介绍
		
		String sql = "select*from tb_user where userName=?";
		List<Object[]> list =DBUtil.executeQurry(sql,new Object[]{userName});
		if(list.size()>0){
			//查看此账号被注册过没
			req.setAttribute("regError", "此账号被占用");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);//请求派发
		}else{
			req.setAttribute("Error", "注册成功");
			//可以注册，执行insert语句
			sql="insert into tb_user(userName,userpass,myForm,sex,education,hobby,introduce) values(?,?,?,?,?,?,?)";
			DBUtil.executeDML(sql, new Object[]{userName,userpass,myForm,sex,education,hobby,introduce});
			req.getRequestDispatcher("view/index.jsp").forward(req, resp);
		}
	}
    
}
