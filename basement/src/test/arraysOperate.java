package test;

public class arraysOperate {
	public static void main(String arr[]) {
		int A[]= {11,22,44,33};
		System.out.println(max_1(A)+"\t我是最大值");
		rank(A);
	}
	static void rank(int arr[]) {
		for( int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<=arr[j]) {
					int t=arr[i];
					arr[i]=arr[j];
					arr[j]=t;
				}
			}
		}
		for(int j=0;j<arr.length;j++) {
			System.out.println(arr[j]);
		}
	}
	static int max_1(int arr[]) {
		int max=arr[0];
		for( int i=0;i<arr.length-1;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
}
