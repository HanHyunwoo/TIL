package com.hw.vo;

public class Population {
	String gu;
	String dong;
	int one;
	int two;
	int three;
	int four;
	int five;
	int six;
	int sevenover;
	
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public int getOne() {
		return one;
	}
	public void setOne(int one) {
		this.one = one;
	}
	public int getTwo() {
		return two;
	}
	public void setTwo(int two) {
		this.two = two;
	}
	public int getThree() {
		return three;
	}
	public void setThree(int three) {
		this.three = three;
	}
	public int getFour() {
		return four;
	}
	public void setFour(int four) {
		this.four = four;
	}
	public int getFive() {
		return five;
	}
	public void setFive(int five) {
		this.five = five;
	}
	public int getSix() {
		return six;
	}
	public void setSix(int six) {
		this.six = six;
	}
	public int getSevenover() {
		return sevenover;
	}
	public void setSevenover(int sevenover) {
		this.sevenover = sevenover;
	}
	
	@Override
	public String toString() {
		return gu + " " + dong + " 1�� : " + one + ", 2�� : " + two + 
				", 2�� : " + two + 
				", 3�� : " + three + 
				", 4�� : " + four + 
				", 5�� : " + five + 
				", 6�� : " + six + 
				", 7�� �̻� : " + sevenover;
	}
	


}
