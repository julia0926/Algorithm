import java.util.Scanner;

public class quicksort {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("hw4_1: 김지인");
		System.out.print("단어 수 입력: ");
		int n=sc.nextInt();
		System.out.print(n+"개의 단어 입력:");
		String[] arr=new String[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.next(); //10개 단어 반복해서 입력 
		}
		System.out.print("퀵 정렬 결과 = ");
		quickSort(arr,0,arr.length-1);
		for(int j=0;j<n;j++)
			System.out.print(arr[j]+" ");//퀵 정렬한 배열을 차례로 출력 
		
	}
	
	public static void quickSort(String[] arr,int p,int r) {
		if(p<r) { //더 이상 배열을 나눌수 없을 때까지 
			int pivot=partition(arr,p,r);//피벗의 위치값을 피벗 변수에 저장 
			quickSort(arr,p,pivot-1);//피벗값을 기준으로 작은 배열을 재귀적으로 퀵소트 
			quickSort(arr,pivot+1,r);//피벗값을 기준으로 큰 배열을 재귀적으로 퀵소트 
		}
		
	}
	public static int partition(String[] arr,int p,int r) {
		String x=arr[r];//기준 원소 pivot 값 
		int i=p-1;//1구역(피벗값보다 작거나 같은)의 끝지점 
		for(int j=p;j<r;j++) {//3구역(아직 검사하지 않은)을 반복해서 검사 
			if(arr[j].equalsIgnoreCase(x)&&arr[j].compareTo(x)==-1) {//문자열이 같거나 작은경우 
				//arr[j].equalsIgnoreCase(x)||arr[j].compareTo(x)==-1
				//arr[j].toLowerCase().compareTo(x.toLowerCase())<=0
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
