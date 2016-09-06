package com.web.fifter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.entity.User;

public class loginFilter implements Filter{

	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
//		String methodName = req.getParameter("methodName");
//		if("login".equals(methodName) ||"reg".equals(methodName)||"logout".equals(methodName)){
			chain.doFilter(req, resp);
		}
//			else{
//			User user = (User)req.getSession().getAttribute("loginUser");
//			if(null != user){
//				chain.doFilter(req, resp);
//			}else{
//				req.setAttribute("loginError", "对不起，请先登录！");
//				resp.getWriter().write("<script type='text/javascript'>window.top.location.href='view/login.jsp';</script>");
//			}
//		}
//	}
//	
 
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("loginFilter初始化了");
	}

}




//request.getSession().setAttribute("Error", "对不起请先登录");
//String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//PrintWriter out = response.getWriter();
//out.write("<script type = 'text/javascript'>window.top.location.href='"+basePath+"index.jsp'</script>");
//}else{
//	chain.doFilter(request, response);





