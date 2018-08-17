package test;
import java.util.Scanner;
import java.util.Arrays;
public class insert {
	public static void main(String[] args) {
		Scanner hy=new Scanner(System.in);
		int arr[]=new int[4];
		for(int i=0;i<3;i++) {
			System.out.println("请输入您的第"+(i+1)+"门成绩");
			arr[i]=hy.nextInt();
		}
		for(int i=0;i<3;i++) {
		System.out.println("请输入您要替换第"+(i+1)+"的成绩");
		int num=hy.nextInt();
		arr[i]=num;
		System.out.println(arr[i]);
		}
		Arrays.sort(arr);
		for(int i=0;i<3;i++) {
		System.out.println(arr[i]);}
	}
}
