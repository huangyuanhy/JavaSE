package test;
import java.util.Scanner;
public class max_1 {
	public static void main(String[] args) {
	Scanner hy=new Scanner(System.in);
	System.out.println("������������");
	int num=hy.nextInt();
		int score[]=new int[num];
	int max=score[0];
	for(int i=0; i<score.length;i++) {
		System.out.println("�������"+(i+1)+"λͬѧ�ĳɼ�");
		score[i]=hy.nextInt();
		if (max<=score[i]) {
			max=score[i];
		}
	}
	System.out.println("�ɼ����Ϊ"+max);
	/*
	 for(int i=score.length-1;i>=1;i--) {
		for(int j=score.length-2;j>=0;j--) {
			if(score[i]>=score[j]) {
				score[i]=score[j];
				int t=score[i];
				score[j]=t;
			}
		}
	}
	*/
	for(int i=0;i<score.length-1;i++) {
		for(int j=i+1;j<score.length;j++) {
			if(	score[i]>score[j]) {
				score[i]=score[j];
				int t=score[i];
				score[j]=t;
		}
		}
	}
		for(int i=0;i<score.length;i++) {

		System.out.println(score[i]);	
		}
	}
}
