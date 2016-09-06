package com.web.entity;

import java.io.Serializable;

public class Menu implements Serializable{
	//id
	private int mid;
	//菜单名字
	private String name;
	//连接地址
	private String url;
	//是否显示出来，1表示显示、0表示不显示
	private int isshow;
	//菜单的级别
	private int level;
	//下级菜单关联上级菜单的 id
	private int parentid;
	public Menu(int mid, String name, String url, int isshow, int level,
			int parentid) {
		this.mid = mid;
		this.name = name;
		this.url = url;
		this.isshow = isshow;
		this.level = level;
		this.parentid = parentid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIsshow() {
		return isshow;
	}
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	
	
	
	
	
}
