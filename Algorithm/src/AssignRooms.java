import java.util.Scanner;
import java.util.StringTokenizer;

public class AssignRooms {

	static class Room{
		String name;
		int startTime,finishTime;
		
		public Room(String name,int startTime,int finishTime) {
			this.name=name;
			this.startTime=startTime;
			this.finishTime=finishTime;
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("hw11_1: 김지인");
		System.out.print("신청 회의 수 입력: ");
		int n=sc.nextInt(); //신청 회의 수 정수로 입력 
		sc.nextLine();
		String[] roomInfo=new String[n];
//		String[] name=new String[n];
//		int[][] time=new int[n][2];
		Room[] rooms=new Room[n];
		System.out.println(n+"개의 회의명과 회의실 사용 시간(시작시와 종료시)을 whitespace로 구분하여 입력:");
		for(int i=0;i<n;i++) {
			roomInfo[i]=sc.nextLine();
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(roomInfo[i]," ");
			String name=st.nextToken();
			int startTime=Integer.parseInt(st.nextToken());
			int finishTime=Integer.parseInt(st.nextToken());
			rooms[i]=new Room(name,startTime,finishTime);
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(rooms[i]);
		}
		
//		for(int i=0;i<n;i++) {
//			String[] info=new String[3];
//			info=roomInfo[i].split(" ");
//			name[i]=info[0];
//			time[i][0]=Integer.parseInt(info[1]); //시작시간 
//			time[i][1]=Integer.parseInt(info[2]); //끝나는 시간 
//			for(int j=0;j<n-(i+1);j++) {
//				if(time[j][1]>time[j+1][1]) {
//					int tmp=time[j][1];
//					time[j][1]=time[j+1][1];
//					time[j+1][1]=tmp;
//				}
//			}
//		}

		
		
//		int count=time[0][1];
//		StringBuffer sb=new StringBuffer();
//		sb.append(roomInfo[0]); //제일 첫번째 문자열 포함 
//		for(int i=1;i<n;i++) {
//			if(count<time[i][0]) {
//				sb.append(roomInfo[i]);
//				count++;
//			}
//		}

	
		
	}

}
