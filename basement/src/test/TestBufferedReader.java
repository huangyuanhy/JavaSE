package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBufferedReader {
	public static void main(String[] args) throws Exception {
		//以System.in节点流，创建一个BufferedReader 对象
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in ));
		String buffer=br.readLine();
		//逐行读取键盘输入
		while(buffer!=null) {
			System.out.println( "键盘输入的内容是"+buffer);
			
		}
	}
}
