package test;
import java.util.Scanner;
public class arr {
	public static void main(String[] args) {
		int sum=0;
		int arr[]=new int[4];
		Scanner hy=new Scanner(System.in);
			for(int i=0;i<arr.length;i++) {
				System.out.println("请输入第个"+(i+1)+"学生的成绩 ");
				arr[i]=hy.nextInt();
				sum+=arr[i];
			}
			System.out.println("平均分为"+sum/4);
	}
}
