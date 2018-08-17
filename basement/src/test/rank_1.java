package test;

public class rank_1 {
	public static void main(String[] args) {
		int score[]= {55,33,4};
		for(int i=0;i<score.length-1;i++) {
			for(int j=i+1;j<score.length;j++) {//Ñ¡ÔñÅÅÐò
				if(	score[i]>score[j]) {
					int t=score[i];
					score[i]=score[j];
					score[j]=t;
				}
			}
		}
		for(int i=0;i<score.length;i++) {
			System.out.println(score[i]);
		}
	}
}