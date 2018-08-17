package test;
import java.util.*;
public class loop_1 {
	public static void main(String[] args) {
		Scanner hy=new Scanner(System.in);
		int A=(int)(Math.random()*101);
		int number;
			do {
				System.out.println("请猜一下电脑随机生成的数是多少（0-100）");
				number=hy.nextInt();
				if(number<A) {
					System.out.println("小了，再猜一下");
					}else if(number>A) {
						System.out.println("大了，再猜一下");
				}
			}while(number!=A);
			System.out.println("恭喜你，猜对了");
	}
}
