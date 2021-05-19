
import java.util.Scanner;

public class Select {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("hw5_1: 김지인");
		System.out.print("20개의 단어 입력: ");
		String[] arr=new String[20];//	20개의 단어가 들어갈 문자열 배열 
		for(int i=0;i<20;i++) {
			arr[i]=sc.next();
		} //20개 입력받음
		
		System.out.println("1번째 작은 단어 = "+select(arr,0,arr.length-1,1));
		System.out.println("6번째 작은 단어 = "+select(arr,0,arr.length-1,6));
		System.out.println("17번째 작은 단어 = "+select(arr,0,arr.length-1,17));
		System.out.println("20번째 작은 단어 = "+select(arr,0,arr.length-1,20));
	

	}
	public static String select(String[] arr,int p,int r, int i) {
		if(p==r)
			return arr[p]; //원소가 1개인 경우 
		int q=partition(arr,p,r);//partition메소드로 q를 지정 
		int k=q-p+1;//k는 기준값이 있어야 하는 인덱스 값 
		if(i<k)
			return select(arr,p,q-1,i); //왼쪽 범위로 줄여 재귀호출한다. 
		else if(i==k) //기준 원소와 찾는 원소가 동일하면 
			return arr[q]; //기준 값을 리턴한다. 
		else //(i>k)
			return select(arr,q+1,r,i-k);//오른쪽 범위로 재귀적으로 호출한다. 
		
	}
	
	public static int partition(String[] arr,int p,int r) {
		String x=arr[r];//기준 원소 pivot 값 
		int i=p-1;//1구역(피벗값보다 작거나 같은)의 끝지점 
		for(int j=p;j<r;j++) {//3구역(아직 검사하지 않은)을 반복해서 검사 
			if(arr[j].toLowerCase().compareTo(x.toLowerCase())<=0) {//문자열이 같거나 작은경우 
				i++;//1구역의 끝지점을 하나 증가 
				String temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp; //1구역의 끝지점과 3구역의 값의 위치를 서로 바꿔준다. 
			}
			//기준값보다 크면 j만 증가되고 기준값보다 작거나 같아도 j값 증가   
		}
		String temp=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=temp;
		//1구역의 끝지점 다음 값과 피벗(기준)값을 교환하여 피벗값을 기준으로 구역을 나눈다. 
		return i+1;//피벗의 위치 값을 리턴 
	}

}
