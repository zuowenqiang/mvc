package com.web.entity;

public class Role {
	//主键id
	private int rid;
	//角色名称
	private String rname;
	
	
	public Role(int rid, String rname) {
		this.rid = rid;
		this.rname = rname;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	
	
	

}
