package colletion;

import java.util.Arrays;
import java.util.Scanner;

public class interview {
	

	    public static void main(String[] args) {
	    	System.out.println("������һ�����֣��Կո����");
	    	Scanner scanner=new Scanner(System.in);
	    	String nextLine = scanner.nextLine();
	    	String[] str=nextLine.split(" ");
	    	int[] num=new int[str.length];
	    	for(int i=0;i<str.length;i++) {
	    		num[i]=Integer.parseInt(str[i]);
	    	}
	    	System.out.println(Arrays.toString(num));
	     
	    }
}
