/**
 * 
 */
package upload;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Administrator
 *
 */
public class TextClient {

	/**
	 * @param args
	 * @throws Exception 
	 * 
	 */
	public static void main(String[] args) throws  Exception {
		// TODO Auto-generated method stub
		System.out.println("�ͻ�������");
		//�ͻ���socket
		Socket socket=new Socket("192.168.1.55",10006);
		//ȷ������Դ �������ļ�
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		//ȷ��Ŀ��   ��socket�����
	//	BufferedWriter bWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		
		//д����
		String line=null;
		while ((line=br.readLine())!=null) {
			out.println(line);
		}
		//�������      �ر���Ҫ������˫��������
		/*out.println("over");*/
		//�˷���ʵ���������������һ���������
		socket.shutdownOutput();
		
		
		//���ط������˵���Ϣ
		BufferedReader bin=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String readLine = bin.readLine();
		System.out.println(readLine);
		
		//�ر�
		bin.close();
		socket.close();
	}

}
