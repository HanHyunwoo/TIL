package day1;

public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char name1 = '한';
		char name2 = '현';
		char name3 = '우';
		
		// ""를 넣음으로써 문자결합으로 한다.  
		System.out.println("" + name1 + name2 + name3);  //결과값 한현우
		
		// 한,현,우의 각각의 아스키값이 + 된다. 
		System.out.print(name1 + name2 + name3);	   //결과값 160272
	}
}
