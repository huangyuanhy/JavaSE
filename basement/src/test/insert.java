package test;
import java.util.Scanner;
import java.util.Arrays;
public class insert {
	public static void main(String[] args) {
		Scanner hy=new Scanner(System.in);
		int arr[]=new int[4];
		for(int i=0;i<3;i++) {
			System.out.println("���������ĵ�"+(i+1)+"�ųɼ�");
			arr[i]=hy.nextInt();
		}
		for(int i=0;i<3;i++) {
		System.out.println("��������Ҫ�滻��"+(i+1)+"�ĳɼ�");
		int num=hy.nextInt();
		arr[i]=num;
		System.out.println(arr[i]);
		}
		Arrays.sort(arr);
		for(int i=0;i<3;i++) {
		System.out.println(arr[i]);}
	}
}
