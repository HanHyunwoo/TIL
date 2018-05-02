package com.hw.vo;

public class Login {	
	
	String id;
	int loginstate;
	int connection;
	int data;
	Double lat;
	Double lon;
	public Login() {
	}
	
	
	public Login(String id, int loginstate, int conn) {	
		this.id = id;
		this.loginstate = loginstate;
		this.connection = conn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLoginstate() {
		return loginstate;
	}
	public void setLoginstate(int loginstate) {
		this.loginstate = loginstate;
	}
	public int getConn() {
		return connection;
	}
	public void setConn(int conn) {
		this.connection = conn;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(Double lat) {
		this.lat = lat;
	}


	public Double getLon() {
		return lon;
	}


	public void setLon(Double lon) {
		this.lon = lon;
	}

	

	
}
