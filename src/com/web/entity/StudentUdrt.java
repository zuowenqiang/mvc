package com.web.entity;

public class StudentUdrt {
	//id 主键
	private int sid;
	//学生名字
	private String name;
	//学生性别
	private int sex;
	
	private String time;
	//班级
	private int deptid;
	
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public  StudentUdrt() {}


	public StudentUdrt(int sid, String name, int sex, int deptid,String time) {
		super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.deptid = deptid;
		this.time = time;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public int getDeptid() {
		return deptid;
	}


	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	
}
