import java.util.Scanner;

public class LongestIncreasingSubsequence {
	
	static String m; //첫번째 문자열 
	static String n; //두번째 문자열
	static StringBuffer part; //부분 문자열을 위한 StringBuffer 
	static String[][] point; //두 문자열의 부분배열을 비교하기 위한 이차원 배열 

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("hw9_1 : 김지인");
		System.out.print("첫번째 문자열 입력:");
		m=sc.nextLine();
		System.out.print("두번째 문자열 입력:");
		n=sc.nextLine();
		System.out.println("LCS 길이 = "+LCS(m.length(),n.length())); //두 문자열 m,n에 공통으로 들어간부분 순서 중 가장 긴 부분 배열의 길이 
		System.out.println("LCS = "+LCSpart(m.length(),n.length())); //두 문자열 m,n에 공통으로 들어간부분 순서 중 가장 긴 부분 배열 

	}
	
	public static int LCS(int mlen,int nlen) { //부분 배열의 길이를 구하기 위한 메소드 
		int[][] c=new int[mlen+1][nlen+1]; //부분 문제의 답을 배열 C에 저장
		point=new String[mlen+1][nlen+1]; // 어느 방향에서 왔는지 표시하기 위함 
		
		for(int i=0;i<=mlen;i++) {
			c[i][0]=0; //세로줄 0번째 모두 0으로 저장 
		}
		for(int j=0;j<=nlen;j++) {
			c[0][j]=0; //가로줄 0번째 모두 0으로 저장 
		}
		for(int i=1;i<=mlen;i++) { 
			for(int j=1;j<=nlen;j++) {
				if(m.charAt(i-1)==n.charAt(j-1)) { //두 문자열의 i-1번째 j-1번째 문자가 같을 때 
					c[i][j]=c[i-1][j-1]+1; //대각선번째 값에 +1 
					point[i][j]="diagonal";//대각선에서 왔음을 표기 
				}
				else { //문자가 같지 않으면 
					c[i][j]=Math.max(c[i-1][j], c[i][j-1]); //왼쪽 문자열과 위쪽 문자열 중 큰 것을 저장 
					if(c[i][j]==c[i-1][j]) point[i][j]="top";//오른쪽에서 왔음을 표기 
					else point[i][j]="left";//왼쪽에서 왔음을 표기 
				}
			}
		}
		return c[mlen][nlen]; //배열 마지막에서 부분배열의 길이 리턴 
	}
	public static String LCSpart(int mlen,int nlen) { //부분 배열을 구하기 위한 메소드 (+선택과제) 
		part=new StringBuffer(); //문자열을 뒤집기 위해 StringBuffer 사용 
		
		while(point[mlen][nlen]!=null) { 
			if(point[mlen][nlen]=="diagonal") { //대각선에서 온 것이면 
				part.append(m.charAt(mlen-1)); //직전 문자를 부분배열에 추가 
				mlen--; nlen--;//대각선 방향으로 옮김 
			}
			else if(point[mlen][nlen]=="top") mlen--; //위에서 온 것이라면 세로값 한칸 앞으로 
			else nlen--;//아래에서 온 것이라면 가로 값을 한칸 앞으로 
		}
		return part.reverse().toString();//구한 부분배열을 뒤집어 본래 부분배열을 리턴 
	}
	
	
}
