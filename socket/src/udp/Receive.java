package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {
	public static void main(String[] args) throws IOException {
		//����socket ��ȷ�˿�
		DatagramSocket datagramSocket =new DatagramSocket(10002);
		//������,�����ݴ浽���ݰ���
		byte[] buf=new byte[1024];
		//�������ݰ�
		DatagramPacket datagramPacket=new DatagramPacket(buf, buf.length);
		
			//����������û���յ����ݾ�һֱ�ȴ�
		datagramSocket.receive(datagramPacket);
		
		//ȡ����
		String ip = datagramPacket.getAddress().getHostAddress();
		System.out.println(ip);
		int port = datagramPacket.getPort();
		System.out.println(port);
		//��ȡ��Ч��Χ�ڵ�����
		String str = new String(datagramPacket.getData(),0,datagramPacket.getLength());
		System.out.println(str);
		//�ر���Դ
		datagramSocket.close();
		
	}
}
