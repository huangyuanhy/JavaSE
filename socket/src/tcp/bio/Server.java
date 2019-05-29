package tcp.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	public static void main(String[] args) throws Exception {
		System.out.println("����������");
		// TODO Auto-generated method stub
		//��������˵�socket ָ���˿ڽ��м���
		ServerSocket serverSocket=new ServerSocket(10003);
		//��ȡ�ͻ��˶���ͨ���ͻ��˵���ͨ��
		Socket socket=serverSocket.accept();
		String hostAddress = socket.getInetAddress().getHostAddress();
		System.out.println(hostAddress +"��������");
		//��ȡsocket��
		InputStream in=socket.getInputStream();
		//��ȡ����
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String string = new String(buf,0,len);
		System.out.println(string);
				
		
		//��������������
		OutputStream outputStream=socket.getOutputStream();
		outputStream.write("server is ready".getBytes());
		//�ر�����
		socket.close();
		serverSocket.close();
	}

}
