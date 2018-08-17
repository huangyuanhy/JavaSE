package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * udp通信
 * @author Administrator
 *
 */
public class Send {
	public static void main(String[] args) throws Exception {
		//创建一个socket
		DatagramSocket datagramSocket=new DatagramSocket(8888);
		//明确传输数据
		String str="udp数据传输";
		//封装到pakpage中
		DatagramPacket datagramPacket=new DatagramPacket(str.getBytes(), str.length());
		//设定目的的
		datagramPacket.setAddress(InetAddress.getByName("192.168.1.55"));
		datagramPacket.setPort(10002);
		datagramSocket.send(datagramPacket);
		//关闭
		datagramSocket.close();
				
	}
	
}
