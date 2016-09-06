package com.web.dao;

import java.util.List;

import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;



public interface UserDao {
	/**
	 * 登录功能
	 * @param userName
	 * @return
	 */
	public User loadUserByName(String userName);
    /**
     * 加载所有用户
     * @return
     */
	public List<User> loadAllUsers();
	/**
	 * 通过账号主键id加载此用户所有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid);
	/**
	 * 显示菜单列表
	 * @return
	 */
	public List<Menu> loadshowMenu(int pageNo,int pageSize);
	/**
	 * 角色列表
	 * @return
	 */
	public List<Role> loadshowRole();
	/**
	 * 添加菜单列表
	 * @param name
	 * @param url
	 * @param isshow
	 * @param parentid
	 */
	public void addMenuto(String name, String url, int isshow,int parentid);
	
	/**
	 * 查询菜单列表
	 */
	public void addMenu(String menuename, String url, int isshow, int level,
			int parentid);
	
	
	/**
	 * 查找1、2级列表
	 * @return
	 */
	public List<Menu> toshow12Menu();
	/**
	 * 根据选择的父菜单的id查询这个父类菜单,
	 * @param parentid
	 * @return
	 */
	public Menu loadByParentid(int parentid);

	/**
	 * 修改权限
	 * @param rid
	 * @param mName
	 */
	public void loadAlterMenu(int rid, String[] mName);
	/**
	 * 查询角色对应的菜单
	 * @param rid
	 * @return
	 */
	public Role loadShowRoleRid(int rid);
	public List<Object[]> showMenuName(int rid);
	/**
	 * 修改用户
	 */
	public void loadAlterRole(int rid, String[] urid);
	/**
	 * 根据rid查询rid对应的用户
	 */
	public List<Object[]> showRoleUser(int rid);

   
	

	
}
