package test;
import java.util.Scanner;
public class arr {
	public static void main(String[] args) {
		int sum=0;
		int arr[]=new int[4];
		Scanner hy=new Scanner(System.in);
			for(int i=0;i<arr.length;i++) {
				System.out.println("������ڸ�"+(i+1)+"ѧ���ĳɼ� ");
				arr[i]=hy.nextInt();
				sum+=arr[i];
			}
			System.out.println("ƽ����Ϊ"+sum/4);
	}
}
