package test;
import java.util.*;
public class score_manage {
	public static void main(String[] args) {
		Scanner hy=new Scanner(System.in);
		System.out.println("������ѧ����������");
		int num=hy.nextInt();
		System.out.println("�������ܿ�Ŀ��");
		int subject=hy.nextInt();
		String A[]=new String[num];//����ѧ��������
		String B[]=new String[subject];//�����Ŀ
		int score[][]=new int[num][subject];//����ѧ���ĳɼ�
		int C[]=new int[num];//�ܷ�
		double D[]=new double[num];//ƽ����
		String F[]=new String[num];//�ϲ�
		String str11="";
		for(int i=0;i<B.length;i++) {
			System.out.println("�붨���"+(i+1)+"�ſ�Ŀ");
			B[i]=hy.next();
		}
		
		for(int i=0;i<num;i++) {
			System.out.println("�������"+(i+1)+"��ѧ��������");
			A[i]=hy.next();
		}
		
		for(int i=0;i<num;i++) {
			int sum=0;
			for(int j=0;j<subject;j++) {
				System.out.println("�������"+A[i]+"ѧ��"+B[j]+"�ĳɼ�");
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
		System.out.print("ѧ��");
		for(int i=0;i<subject;i++) {
			System.out.print("\t"+B[i]);
		}
		System.out.println("\t�ܷ�\tƽ����\t����");
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
