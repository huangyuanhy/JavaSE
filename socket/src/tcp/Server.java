package tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	public static void main(String[] args) throws Exception {
		System.out.println("服务器启动");
		// TODO Auto-generated method stub
		//创建服务端的socket 指定端口进行监听
		ServerSocket serverSocket=new ServerSocket(10003);
		//获取客户端对象，通过客户端的流通信
		Socket socket=serverSocket.accept();
		String hostAddress = socket.getInetAddress().getHostAddress();
		System.out.println(hostAddress +"正在连接");
		//获取socket流
		InputStream in=socket.getInputStream();
		//读取数据
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String string = new String(buf,0,len);
		System.out.println(string);
				
		
		//服务器发动数据
		OutputStream outputStream=socket.getOutputStream();
		outputStream.write("server is ready".getBytes());
		//关闭连接
		socket.close();
		serverSocket.close();
	}

}
