package com.hw.vo;

public class User {	
	
	String id;
	String password;
	String name;
	int manager;
	String registdate;
	
	public User() {
	}
	
	public User(String id) {
		this.id = id;

		
	}
	public User(String id, String pwd) {
		this.id = id;
		this.password = pwd;
		
	}
	
	public User(String id, String pwd, String name) {
		this.id = id;
		this.password = pwd;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return password;
	}
	public void setPwd(String pwd) {
		this.password = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	
	
	public String getRegistdate() {
		return registdate;
	}

	public void setRegistdate(String registdate) {
		this.registdate = registdate;
	}

	@Override
	public String toString() {
		return id+" "+password+" "+name+" "+manager+" "+registdate;
	}

}
