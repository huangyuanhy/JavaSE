package test;
import java.util.Scanner;
public class arr_2 {
	public static void main(String[] args) {
		Scanner hy=new Scanner(System.in);
		String arr[][]=new String[3][2];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[j].length;j++) {
				System.out.println("�������"+(i+1)+"�е�"+(j+1)+"������");
				String name=hy.next();
				arr[i][j]=name;
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[j].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}
