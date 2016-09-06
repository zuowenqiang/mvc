package com.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.maodel.UserModel;
import com.web.maodel.impl.UserModelImpl;
import com.web.util.DBUtil;

public class MainServlet extends HttpServlet{
	
	//控制层持有一个模型层对象
	private UserModel userModel=new UserModelImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接受所有请求
		req.setCharacterEncoding("UTF-8");
		String method = req.getParameter("methodName");
		System.out.println(method);
		java.lang.Class<MainServlet> c= MainServlet.class;
		try {
			Method m = c.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, req,resp);
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	
	}
	/**
	 * 登录功能
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		//1、取出表单数据
		String userName = req.getParameter("userName");
		String userpass =req.getParameter("userpass");
		System.out.println(userName);
		System.out.println(userpass);

		//2、查询数据库			
		User user = userModel.loadUserByName(userName);
		if(user != null){
			if(userpass.equals(user.getUserpass())){
				//密码正确  登录成功  查看当前用户有哪些菜单
				List<Menu> menuList= userModel.loadMenusByUid(user.getUid());
				req.getSession().setAttribute("menuList", menuList);
				//保存数据，整个项目中都有效
				req.getSession().setAttribute("loginUser", user);
				resp.sendRedirect("view/Welcome.jsp");
			}else{
				req.setAttribute("loginError", "密码输入错误，请重新输入！");
				resp.sendRedirect("view/index.jsp");
			}
		   }else{
		   req.setAttribute("loginError", "账号输入错误，请重新输入！");
		   resp.sendRedirect("view/index.jsp");
	}
		
	}


	/**
	 * 用户展示
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUser(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
		List<User> userList = userModel.loadAllUsers();
		System.out.println(userList.size());
		req.setAttribute("userList", userList);
		req.setAttribute("date", new Date());
		req.getRequestDispatcher("view/showUser.jsp").forward(req, resp);

	}
	
	
	/**
	 * 显示菜单列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMenu(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		int pageNo=Integer.valueOf("pageNo");
		int pageSize=Integer.valueOf("pageSize");
		List<Menu> showList = userModel.loadshowMenu(pageNo,pageSize);
		System.out.println(showList.size());
		req.setAttribute("showList", showList);
		req.setAttribute("date", new Date());
		req.getRequestDispatcher("view/showMenu.jsp").forward(req, resp);
	}
	
	/**
	 * 角色展示
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void showRole(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
	List<Role> roleList = userModel.loadshowRole();
	System.out.println(roleList.size());
	req.setAttribute("roleList", roleList);
	req.setAttribute("date", new Date());
	req.getRequestDispatcher("view/Role.jsp").forward(req, resp);

}	
	
	/**
	 * 查找1、2级菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMenu(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		System.out.println("控制层菜单查询");
		List<Menu> MenueList=userModel.toshow12Menu();
		System.out.println(MenueList.size());
		req.setAttribute("MenueList", MenueList);
		req.getRequestDispatcher("view/addMenu.jsp").forward(req, resp);	
	}
	/**
	 * 添加菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMenuto(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		System.out.println("控制层增加菜单方法");
		String name =req.getParameter("name");
		String url=req.getParameter("url");
		String isshow=req.getParameter("isshow");
		String parentid =req.getParameter("parentid");
		userModel.addMenuto(name,url,Integer.valueOf(isshow),Integer.valueOf(parentid));
		
	
	}
	/**
	 * 根据rid查询rid对应的用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showRoleRid(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String rid = req.getParameter("rid");
		
		Role role = userModel.loadShowRoleRid(Integer.valueOf(rid));
		req.setAttribute("role", role);
		
		List<Object[]> uList=userModel.showRoleUser(Integer.valueOf(rid));
		req.setAttribute("uList", uList);
		req.getRequestDispatcher("view/AlterRole.jsp").forward(req, resp);
	}
	/**
	 * 修改角色用户
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void AlterRole(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		String rid = req.getParameter("rid");
		String[] urid = req.getParameterValues("urid");
		
		userModel.loadAlterRole(Integer.valueOf(rid), urid);
		this.showRole(req, resp);
		}
	
	
	
	
	
	/**
	 * 查询角色对应的菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMenuRid(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String rid = req.getParameter("rid");
		
		Role role = userModel.loadShowRoleRid(Integer.valueOf(rid));
		req.setAttribute("role", role);
		
		List<Object[]> list=userModel.showMenuName(Integer.valueOf(rid));
		req.setAttribute("list", list);
		req.getRequestDispatcher("view/AlterUser.jsp").forward(req, resp);
	}
	/**
	 * 修改权限
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void alterMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("rid");
		String[] mName = req.getParameterValues("mName");
		userModel.loadAlterMenu(Integer.valueOf(rid), mName);
		this.showRole(req, resp);
	}
	/**
	 * ajax  阿贾克斯
	 * 页面刷新的是同步请求
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void testAJAX(HttpServletRequest req, HttpServletResponse resp)
	       throws ServletException, IOException{
		System.out.println("AJAX来了");
		
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("{\"address\":\"重庆渝中区\",\"name\":\"小次郎\"}");
		resp.getWriter().flush();
	
		
		
	}
	

   
}	
	
	