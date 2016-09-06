package com.web.entity;

import java.io.Serializable;

public class User implements Serializable{
	private int uid;//主键
	private String userName;//账号
	private String userpass;//密码
	private String myForm;//邮箱
	private int sex;//性别
	private int education;//学历
	private String  hobby;//爱好
	private String introduce;//简历
	
	
	
	
	public User(int uid, String userName, String userpass, String myForm,
			int sex, int education,String  hobby, String introduce) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.userpass = userpass;
		this.myForm = myForm;
		this.sex = sex;
		this.education = education;
		this.hobby=hobby;
		this.introduce = introduce;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getMyForm() {
		return myForm;
	}
	public void setMyForm(String myForm) {
		this.myForm = myForm;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
	
	
}
