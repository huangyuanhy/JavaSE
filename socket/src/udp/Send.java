package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * udpͨ��
 * @author Administrator
 *
 */
public class Send {
	public static void main(String[] args) throws Exception {
		//����һ��socket
		DatagramSocket datagramSocket=new DatagramSocket(8888);
		//��ȷ��������
		String str="udp���ݴ���";
		//��װ��pakpage��
		DatagramPacket datagramPacket=new DatagramPacket(str.getBytes(), str.length());
		//�趨Ŀ�ĵ�
		datagramPacket.setAddress(InetAddress.getByName("192.168.1.55"));
		datagramPacket.setPort(10002);
		datagramSocket.send(datagramPacket);
		//�ر�
		datagramSocket.close();
				
	}
	
}
