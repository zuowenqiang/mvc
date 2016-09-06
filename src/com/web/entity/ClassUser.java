
package com.web.entity;

public class ClassUser {
	//id 主键
	private int cid;

	private String cname;
	
	private String time;

	public ClassUser(int cid, String cname, String time) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.time = time;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return cname;
	}

	public void setName(String name) {
		this.cname = cname;
	}

	public String getTimes() {
		return time;
	}

	public void setTimes(String time) {
		this.time = time;
	}
	
	
   
}
