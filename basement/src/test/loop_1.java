package test;
import java.util.*;
public class loop_1 {
	public static void main(String[] args) {
		Scanner hy=new Scanner(System.in);
		int A=(int)(Math.random()*101);
		int number;
			do {
				System.out.println("���һ�µ���������ɵ����Ƕ��٣�0-100��");
				number=hy.nextInt();
				if(number<A) {
					System.out.println("С�ˣ��ٲ�һ��");
					}else if(number>A) {
						System.out.println("���ˣ��ٲ�һ��");
				}
			}while(number!=A);
			System.out.println("��ϲ�㣬�¶���");
	}
}
