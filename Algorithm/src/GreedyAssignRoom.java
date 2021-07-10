import java.util.Scanner;

public class GreedyAssignRoom {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("hw11_1: 김지인");
		System.out.print("신청 회의 수 입력: ");
		int n=sc.nextInt(); //신청 회의 수 정수로 입력 
		sc.nextLine();
		
		String[] roomInfo=new String[n]; //회의실 정보를 한번에 받을배열 
		String[] name=new String[n]; //회의실 이름 문자열 배열 
		int[] startTime=new int[n]; // 시작시간 배열 
		int[] finishTime=new int[n]; // 끝나 시간 배열 
		System.out.println(n+"개의 회의명과 회의실 사용 시간(시작시와 종료시)을 whitespace로 구분하여 입력:");

		 //회의실 정보를 한줄에 입력 
		for(int i=0;i<n;i++) {
			roomInfo[i]=sc.nextLine();
		}
		//입력받은 정보를 각 정보에 맞게 나눔 
		for(int i=0;i<n;i++) {
			String[] info=new String[3];
			info=roomInfo[i].split(" ");
			name[i]=info[0];
			startTime[i]=Integer.parseInt(info[1]);
			finishTime[i]=Integer.parseInt(info[2]);
		}
		//끝나는 시간순으로 정렬 (버블 정렬 사용 )
		for(int i = 0; i <n; i++) {
	        for(int j = 0 ; j < n - i - 1 ; j++) {
	            if(finishTime[j] > finishTime[j+1]) { //현재 끝 시간보다 다음 끝 시간이 크다면 
	            	//모든 정보의 순서를 교환 
	                swap(name,j,j+1);
	                swapNum(startTime,j,j+1);
	                swapNum(finishTime,j,j+1);
	            }
	        }
	    }
		//시작 값 구하기
		int index=0;
		for(int i=0;i<n;i++) {
			if(startTime[i]>=6) { //시작하는 시간이 6시부터 이므로 
				index=i; //시작시간이 있는 index값을 구함 
				break;
			}
		}
		
		StringBuffer sb=new StringBuffer();
		sb.append(name[index]+" ("+startTime[index]+","+finishTime[index]+")\n"); //이전에 구한 첫번째 정보를 저장 
		int count=1;
		int max=finishTime[index]; //일단 현재 값을 제일 큰 끝나는 시간으로 둠 
		for(int i=index+1;i<n;i++) { 
			if(max<=startTime[i]){//끝나는 시간보다 다음 시작 값이 큰 경우 
				if(finishTime[i]<24) { //종료시간이 24시가 넘지 않을 때만 
					count++; //회의실 정보 갯수를 증가 
					max=finishTime[i]; //끝나는 시간정보를 max값과 교환하여 다시 비교하게 함 .
					sb.append(name[i]+" ("+startTime[i]+","+finishTime[i]+")\n"); //조건에 맞는 정보를 저장 
				}
			}
		}

		System.out.println("선정된 회의 수 = "+count); //선정된 회의실 갯수를 출력 
		System.out.println("선정된 회 스케쥴 = ");
		System.out.println(sb); //선정된 회의실 정보들을 출력 
		
	}
	//문자열 배열의 위치를 바꾼다. 
	public static void swap(String[] array, int i1, int i2) {
        String temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;        
    }
	//숫자 배열의 위치를 바꾼다 .
	public static void swapNum(int[] array,int i1,int i2) {
		int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp; 
	}


}
