package com.hw.controller;

public class TestRequest {

	public static void main(String[] args) {
		int i = randomRange(30,100);
		
		//http://70.12.114.143/Server/logAdd.do?CARID=1&ACCEL=2&DECEL=3&SAFETYDIS=4&SNOOZE=5&SPEED=6&BATTERY=7
			
			
	}

	public static int randomRange(int n1, int n2) {
		return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	}

}
