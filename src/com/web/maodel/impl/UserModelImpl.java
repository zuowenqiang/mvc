package com.web.maodel.impl;

import java.util.List;

import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.maodel.UserModel;
import com.web.util.DBUtil;

public class UserModelImpl implements UserModel {
	//模型层持有一个DAO层对象
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName 用户输入的帐号
	 * @return 返回null表示用户的帐号不存在 
	 */
	public User loadUserByName(String userName){
		System.out.println("UserModelMySQLImpl模型层");
		User user = userDao.loadUserByName(userName);
		return user;
	}
	/**
	 *加载所有用户展示
	 */
	@Override
	public List<User> loadAllUsers() {
		return userDao.loadAllUsers();
	}
	/**
	 * 通过账号主键id加载此用户所有的菜单集合
	 */
	@Override
	public List<Menu> loadMenusByUid(int uid) {
		return userDao.loadMenusByUid(uid);
	}
	/**
	 * 显示菜单列表
	 * @return
	 */
	@Override
	public List<Menu> loadshowMenu(int pageNo,int pageSize) {
		return userDao.loadshowMenu(pageNo,pageSize);
	}
	@Override
	public List<Role> loadshowRole() {
		return userDao.loadshowRole();
	}
	/**
	 * 添加菜单列表
	 */
	@Override
	public void addMenuto(String name, String url, int isshow,int parentid) {
		this.userDao.addMenuto(name,url,isshow,parentid);
	}

	/**
	 * 查找1、2级列表
	 */
	@Override
	public List<Menu> toshow12Menu() {
		return userDao.toshow12Menu();
	}
	@Override
	public boolean loadByParentid(String name, String url, int isshow,
			int parentid) {
		Menu m=userDao.loadByParentid(parentid);
		if(null!=m){
			//子菜单的级别是父菜单的级别加1
			int level=m.getLevel()+1;
			userDao.addMenu(name, url, isshow, level, parentid);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 修改权限
	 */
	@Override
	public void loadAlterMenu(int rid, String[] mName) {
		userDao.loadAlterMenu(rid,mName);		
	}
	/**
	 * 查询角色对应的菜单
	 */
	@Override
	public Role loadShowRoleRid(int rid) {
		return userDao.loadShowRoleRid(rid);
	}
	/**
	 * 查询角色对应的菜单
	 * @param rid
	 * @return
	 */
	@Override
	public List<Object[]> showMenuName(int rid) {
		return userDao.showMenuName(rid);
	}
	
	
	/**
	 * 修改用户
	 */
	@Override
	public void loadAlterRole(int rid, String[] urid) {
		userDao.loadAlterRole(rid,urid);
	}
	/**
	 * 根据rid查询rid对应的用户
	 */
	@Override
	public List<Object[]> showRoleUser(int rid) {
		return userDao.showRoleUser(rid);
	}
	
	

}




