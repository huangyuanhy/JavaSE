package tcp.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		System.out.println("�ͻ�������");
		//�����ͻ��˶��� ��ȷ�˿ں͵�ַ
		Socket socket=new Socket("192.168.1.55", 10003);
		//��ȡsocket��������������ݷ��͸������
		OutputStream outputStream=socket.getOutputStream();
		//д������
		outputStream.write("tcp����".getBytes());
		
		
		//��ȡ����˷��ص�����
		InputStream inputStream=socket.getInputStream();
		byte[] buf=new byte[1024];
		
		int read = inputStream.read(buf);
		String string=new String(buf, 0, read);
		System.out.println("����˷��ص�����"+string);
		//�ر�����
		socket.close();
	}
}
