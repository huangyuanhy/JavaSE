package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {
	public static void main(String[] args) throws IOException {
		//创建socket 明确端口
		DatagramSocket datagramSocket =new DatagramSocket(10002);
		//收数据,将数据存到数据包中
		byte[] buf=new byte[1024];
		//创建数据包
		DatagramPacket datagramPacket=new DatagramPacket(buf, buf.length);
		
			//阻塞方法，没有收到数据就一直等待
		datagramSocket.receive(datagramPacket);
		
		//取数据
		String ip = datagramPacket.getAddress().getHostAddress();
		System.out.println(ip);
		int port = datagramPacket.getPort();
		System.out.println(port);
		//获取有效范围内的数据
		String str = new String(datagramPacket.getData(),0,datagramPacket.getLength());
		System.out.println(str);
		//关闭资源
		datagramSocket.close();
		
	}
}
