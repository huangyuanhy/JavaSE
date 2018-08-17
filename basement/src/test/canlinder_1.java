package test;

public class canlinder_1 {
	public static void main(String[] args) {
		int sum=0;	
		int total=1;
		for(int i=0;i<=2017;i++) {
				if(i%4==0&&i%100!=0||i%400==0) {
					System.out.println(i+"年是瑞年");
					sum=sum+1;
				}
			}
		System.out.println("总共有"+sum+"年是瑞年");
		total=sum*366+(2017-sum)*365;
		System.out.println("总共有"+total+"天");
	
	}
}
