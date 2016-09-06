package com.web.maodel;

import java.util.List;

import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;

public interface UserModel {
	/**
	 * 登录
	 * @param userName
	 * @return
	 */
	public User loadUserByName(String userName);
	/**
	 * 加载所有用户展示
	 * @return
	 */
	public List<User> loadAllUsers();
	/**
	 * 通过账号主键id加载此用户所有的菜单集合
	 */
	public List<Menu> loadMenusByUid(int uid);

	/**
	 * 显示菜单列表
	 * @return
	 */
	public List<Menu> loadshowMenu(int pageNo,int pageSize);
	/**
	 * 角色列表
	 */
    public List<Role> loadshowRole();
    
    
    /**
     * 添加菜单列表
     * @param name
     * @param url
     * @param valueOf
     * @param valueOf2
     * @return
     */
	 public  void addMenuto(String name, String url, int isshow, int parentid);
	 
	 /**
	  * 查找1、2级菜单
	  * @return
	  */
	 public List<Menu> toshow12Menu();
	 
	 /**
	  * 
	  * @param name
	  * @param url
	  * @param valueOf
	  * @param valueOf2
	  * @return
	  */
	 public boolean loadByParentid(String menuename,String url,int isshow,int parentid);
	
	/**
	 * 修改权限
	 * @param valueOf
	 * @param mName
	 */
	public void loadAlterMenu(int rid, String[] mName);
	/**
	 * 根据rid查询角色信息
	 * @param valueOf
	 * @return
	 */
	public Role loadShowRoleRid(int rid);
	/**
	 * 查询角色对应的菜单
	 * @param rid
	 * @return
	 */
	public List<Object[]> showMenuName(int rid);
	/**
	 * 修改用户
	 * @param valueOf
	 * @param urid
	 */
	public void loadAlterRole(int  rid, String[] urid);
	/**
	 * 根据rid查询rid对应的用户
	 * @param valueOf
	 * @return
	 */
	public List<Object[]> showRoleUser(int rid);
	
	 
	 
	 
	
	 
	
	
	
	
	
	
	 
	
	
	
}

