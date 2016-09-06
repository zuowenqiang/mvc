package com.web.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.dao.UserDao;
import com.web.entity.User;
import com.web.util.DBUtil;

public class UserDaoImpl implements UserDao{
	private Object level;


	/**
	 * 通过用户名加载一个对象
	 */

	@Override
	public User loadUserByName(String userName) {
		String sql = "select*from tb_user where userName=?";
		List<Object[]> list =DBUtil.executeQurry(sql,new Object[]{userName});
		User user=null;
		if(list.size()>0){
		    Object[] os = list.get(0);
		    user =new User((Integer)os[0],(String)os[1],(String)os[2],(String)os[3],(Integer)os[4],(Integer)os[5],(String)os[6],(String)os[7]);
		}
		return user;
	}
	
	
	/**
	 * 加载所有用户展示
	 */
	@Override
	public List<User> loadAllUsers() {
		String sql="select*from tb_user";
		List<Object[]>list=DBUtil.executeQurry(sql,null );
		List<User>userList=new ArrayList<User>();
		User user = null;
		if(null!=list&&list.size()>0){
			for(Object[] os:list){
				user= new User((Integer)os[0],String.valueOf(os[1]),String.valueOf(os[2]),(String)os[3],(Integer)os[4],(Integer)os[5],(String)os[6],(String)os[7] );
				userList.add(user);
			}
		}
		return userList;
	}
	
	/**
	 * 通过账号主键id加载此用户所有的菜单集合
	 */
	@Override
	public List<Menu> loadMenusByUid(int uid) {
		System.out.println(uid);
		String sql = "select  m.* from userrole ur,rolemenu rm,menu m where ur.rid=rm.rid and rm.mid=m.mid and m.isshow=1 and ur.uid=? " ;
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{uid});
		
		List<Menu>menuList =new ArrayList<Menu>();
		Menu m = null;
		if(null!=list && list.size()>0){
			for(Object[] os: list){
				m=new Menu((Integer)os[0],String.valueOf(os[1]),String.valueOf(os[2]),(Integer)os[3],(Integer)os[4], (Integer)os[5]);
				menuList.add(m);
			}
		}
		return menuList;
	}
	
    /**
     * 显示菜单列表
     */
	@Override
	public List<Menu> loadshowMenu(int pageNo,int pageSize) {
		String sql="select*from menu";
		List<Object[]>list=DBUtil.executeQurry(sql,null );
		List<Menu>showList=new ArrayList<Menu>();
		Menu menu = null;
		if(null!=list&&list.size()>0){
			for(Object[] os:list){
				menu= new Menu((Integer)os[0],String.valueOf(os[1]),String.valueOf(os[2]),(Integer)os[3],(Integer)os[4],(Integer)os[5]);
				showList.add(menu);
			}
		}
		//return showList;
		sql="select  * from menu";
		return showList;
	}
	
	/**
	 *角色菜单显示
	 */
	@Override
	public List<Role> loadshowRole() {
		String sql="select*from role";
		List<Object[]>list=DBUtil.executeQurry(sql,null );
		List<Role>roleList=new ArrayList<Role>();
		Role r = null;
		if(null!=list&&list.size()>0){
			for(Object[] os:list){
				r= new Role((Integer)os[0],(String)os[1]);
				roleList.add(r);
			}
		}
		return roleList;
	}
	/**
	 * 添加菜单列表
	 */
	@Override
	public void addMenu(String name, String url, int isshow, int level, int parentid) {
		String sql = "insert into menu(name,url,isshow,level,parentid) values(?,?,?,?,?)";
		DBUtil.executeDML(sql, new Object[]{name,url,isshow,level,parentid});
	}
    /**
     * 查找1、2级菜单
     */
	@Override
	public List<Menu> toshow12Menu() {
		String sql ="select * from menu where level in(1,2)";
		List<Object[]> menuList = DBUtil.executeQurry(sql, null);
		List<Menu>MenuList=new ArrayList<Menu>();
		Menu menu = null;
		if(menuList.size()>0){
			for(Object[] o :menuList){
				menu = new Menu((Integer)o[0], (String)o[1],(String)o[2],(Integer)(o[3]),(Integer)o[4],(Integer)(o[5]));
				MenuList.add(menu);
			}
		}	
		return MenuList;
	}


	@Override
	public Menu loadByParentid(int parentid) {
		String sql="select * from menu where parentid=?";
		List<Object[]> list=DBUtil.executeQurry(sql, new Object[]{parentid});
		if(list.size()>0){
			Object[] os=list.get(0);
			Menu menue=new Menu((Integer)os[0],(String)os[1],(String)os[2],(Integer)os[3],(Integer)os[4],(Integer)os[5]);
			System.out.println(menue);
		return menue;
		}
		return null;
	}
	
 

	/**
	 * 查询菜单
	 */
	public List<Object[]> showMenuName(int rid){
		String sql = "select m.mid,m.name,(select 1 from rolemenu rm where rm.mid=m.mid and rm.rid=?) from menu m";
		
		return DBUtil.executeQurry(sql, new Object[]{rid});
		
	}
	/**
	 * 根据rid查询角色信息
	 * @return
	 */
	@Override
	public Role loadShowRoleRid(int rid) {
		String sql = "select*from role where rid=? ";
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{rid});
		Role role = null;
		if(list.size()>0&&list!=null){
			Object[] os = list.get(0);
			role = new Role(rid,String.valueOf(os[1]));
		}
		return role;
	}
	
	/**
	 * 修改角色权限
	 * @param rid
	 * @param s
	 */		
	public void loadAlterMenu(int rid,String[] mName){
		String sql = "delete from rolemenu where rid=?";
		DBUtil.executeDML(sql, new Object[]{rid});
		
		sql = "insert into rolemenu(rid,mid) values(?,?)";
		for(String mNames:mName){
		DBUtil.executeDML(sql, new Object[]{rid,mNames});
		}
	}

    /**
     * 修改用户
     */
	@Override
	public void loadAlterRole(int rid, String[] urid) {
		String sql = "delete from tb_user where uid=?";
		DBUtil.executeDML(sql, new Object[]{rid});
		
		sql = "insert into userrole(uid,rid) values(?,?)";
		for(String urids:urid){
			DBUtil.executeDML(sql, new Object[]{urids,rid});
			}
		
	}

    /**
     * 根据rid查询rid对应的用户
     */
	@Override
	public List<Object[]> showRoleUser(int rid) {
		String sql = "select u.uid,u.userName,(select 1 from userrole ur where ur.uid=u.uid and ur.rid=?) from tb_user u";
		List<Object[]> pList = DBUtil.executeQurry(sql,new Object[]{rid});
		return pList;
	}
	/**
	 * 添加菜单
	 * 
	 */
	public void addMenuto(String name, String url, int isshow,int parentid) {
		//通过菜单父类编号，获取菜单级别
		System.out.println("数据层增加菜单");
		String sq="select *from menu where mid=?";
		List<Object[]> obj=DBUtil.executeQurry(sq,new Object[]{parentid});
		Object[] menus=obj.get(0);
		System.out.println(menus[4]);
		//插入数据
		sq="insert into menu(name,url,isshow,level,parentid)values(?,?,?,?,?)";
		DBUtil.executeDML(sq, new Object[]{name,url,isshow,(Integer)menus[4]+1,parentid});
		
	}
 
}
