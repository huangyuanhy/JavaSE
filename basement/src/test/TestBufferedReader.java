package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBufferedReader {
	public static void main(String[] args) throws Exception {
		//��System.in�ڵ���������һ��BufferedReader ����
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in ));
		String buffer=br.readLine();
		//���ж�ȡ��������
		while(buffer!=null) {
			System.out.println( "���������������"+buffer);
			
		}
	}
}
