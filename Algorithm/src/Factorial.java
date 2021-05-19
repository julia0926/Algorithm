import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("hw0_2: 김지인");
		System.out.print("양의 정수 n 입력: ");
		int n=sc.nextInt(); //n을 입력 
		System.out.println();
		System.out.println("factorial("+n+") = "+factorial(n));//팩토리얼의 곱한 결과 값 출력 및 호출 
		System.out.print("show("+n+") = ");//show() 안내 할 출력문 
		show(n);//show()호출 
		
		
	}
	public static int factorial(int n) { //리턴 값은 int이며 매개변수는 n인 메소드 
		if(n==1) return 1;//f(1)=1
		return n*factorial(n-1);//재귀 함수를 이용해서 팩토리얼 계산 
	}
	public static void show(int n) {//리턴 값은 없으며 매개변수는 n인 메소드 
		if(n==0) return;//n=0이면 재귀함수 호출을 종료한다. 
		show(n-1);//재귀함수를 사용해서 정수 값들 호출 
		System.out.print(n+" ");//show(1)~show(n)까지 값들을 출력한다. 
		
	}

}
