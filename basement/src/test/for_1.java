package test;
import java.util.Scanner;
public class for_1 {
		public static void main(String[] args){
		Scanner hy=new Scanner(System.in);
		System.out.println("������ѧ����������");
		String name=hy.next();
		int sum=0;
			for(int i=0;i<5;i++){
			System.out.println("�������"+(i+1)+"�ſγɼ���");
			int score=hy.nextInt();
			sum=sum+score;
			}
			int average=sum/5;
			System.out.println(name+"��ƽ���ֳɼ���:"+average);
		}
}
