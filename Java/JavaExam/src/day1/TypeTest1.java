package day1;
public class TypeTest1 {
	public static void main(String[] args) {
		System.out.println(100+200);
		System.out.println("100"+200);
		System.out.println(100-200);
		//System.out.println("100"-200); 에러뜸, 문자와 숫자 -연산은 할 수 없다. 
		System.out.println('A');
		System.out.println('A'+1);  //49, 0x31
		//System.out.println(A);    // "",'' 없이 문자 단독으로 적으면 안된다. 변수는 가능
	}
}
