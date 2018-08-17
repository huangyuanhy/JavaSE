package test;
import java.util.*;
public class score_manage {
	public static void main(String[] args) {
		Scanner hy=new Scanner(System.in);
		System.out.println("请输入学生的总人数");
		int num=hy.nextInt();
		System.out.println("请输入总科目数");
		int subject=hy.nextInt();
		String A[]=new String[num];//数组学生的名字
		String B[]=new String[subject];//数组科目
		int score[][]=new int[num][subject];//数组学生的成绩
		int C[]=new int[num];//总分
		double D[]=new double[num];//平均分
		String F[]=new String[num];//合并
		String str11="";
		for(int i=0;i<B.length;i++) {
			System.out.println("请定义第"+(i+1)+"门科目");
			B[i]=hy.next();
		}
		
		for(int i=0;i<num;i++) {
			System.out.println("请输入第"+(i+1)+"个学生的名字");
			A[i]=hy.next();
		}
		
		for(int i=0;i<num;i++) {
			int sum=0;
			for(int j=0;j<subject;j++) {
				System.out.println("请输入第"+A[i]+"学生"+B[j]+"的成绩");
				score[i][j]=hy.nextInt();
				sum+=score[i][j];
				str11+=score[i][j];
 			}
			 C[i]=sum;
			 D[i]=sum/subject;
			 F[i]=A[i]+"\t"+str11+"\t"+C[i]+"\t"+D[i];
		}
		for(int i=0;i<B.length-1;i++) {
			for(int j=0;j<B.length-1;j++) {
				if(C[j]<C[j+1]){
					int t=C[j];		String t1=F[j];
					C[j]=C[j+1];	F[j]=F[j+1];
					C[j+1]=t;		F[j+1]=t1;
				}
			}
		}
		System.out.print("学生");
		for(int i=0;i<subject;i++) {
			System.out.print("\t"+B[i]);
		}
		System.out.println("\t总分\t平均分\t排名");
		System.out.println();
		for(int i=0;i<num;i++) {
			System.out.print(A[i]);
	 			for(int j=0;j<subject;j++) {
	 				System.out.print("\t"+score[i][j]);
	 			}
 				System.out.print("\t"+C[i]+"\t"+D[i]);
 				System.out.println();
	 	}
	}
}
