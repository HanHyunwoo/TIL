package day1;

public class Exercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 100;
		int result;
		result = number + 10;		
		result = number - 10;		
		result = number * 10;		
		result = number / 10;
		//당연히 제일 마지막 result = number / 10 값이 result에 담긴다.
		System.out.println("출력형식 : 덧셈 연산의 결과 - " + result);
		System.out.println("출력형식 : 뺄셈 연산의 결과 - " + result);
		System.out.println("출력형식 : 곱셈 연산의 결과 - " + result);
		System.out.println("출력형식 : 나눗셈 연산의 결과 - " + result);

	}

}
