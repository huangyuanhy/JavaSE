package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		System.out.println("客户端启动");
		//创建客户端对象 明确端口和地址
		Socket socket=new Socket("192.168.1.55", 10003);
		//获取socket中输出流，将数据发送给服务端
		OutputStream outputStream=socket.getOutputStream();
		//写出数据
		outputStream.write("tcp连接".getBytes());
		
		
		//读取服务端发回的数据
		InputStream inputStream=socket.getInputStream();
		byte[] buf=new byte[1024];
		
		int read = inputStream.read(buf);
		String string=new String(buf, 0, read);
		System.out.println("服务端返回的数据"+string);
		//关闭连接
		socket.close();
	}
}
