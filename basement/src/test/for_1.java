package test;
import java.util.Scanner;
public class for_1 {
		public static void main(String[] args){
		Scanner hy=new Scanner(System.in);
		System.out.println("请输入学生的姓名：");
		String name=hy.next();
		int sum=0;
			for(int i=0;i<5;i++){
			System.out.println("请输入第"+(i+1)+"门课成绩：");
			int score=hy.nextInt();
			sum=sum+score;
			}
			int average=sum/5;
			System.out.println(name+"的平均分成绩是:"+average);
		}
}
