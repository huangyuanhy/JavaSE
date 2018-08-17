package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.security.spec.DSAGenParameterSpec;

import org.junit.Test;
/**
 * ͨ�����ݽ��պͷ���ʵ��һ�����칤�� ���ö��߳�ʵ��
 * @author Administrator
 *
 */
public class Chat {
	@Test
	public void test() throws IOException {
		//���Ͷ�
		DatagramSocket send=new DatagramSocket(8888);
		//���ն�
		DatagramSocket receive=new DatagramSocket(12345);
		//�����߳�
		new Thread(new SendData(send)).start();
		new Thread(new ReceiveData(receive)).start();
	}


}
//���ݷ��Ͷ�
class SendData implements Runnable{
	private DatagramSocket datagramSocket;
	public SendData(DatagramSocket datagramSocket) {
		datagramSocket=this.datagramSocket;
	}

	@Override
	public void run() {

		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		try {
			//��������
			String string=null;
			while ((string=bufferedReader.readLine()) != null) {
				if ("over".equals(string)){
					break;
				}
				//��װ
				byte[] bytes = string.getBytes();
				DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length,InetAddress.getByName("192.168.1.55"),12345);
				//����
				datagramSocket.send(datagramPacket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}


//���ݽ��ն�
class ReceiveData implements Runnable{
	private DatagramSocket datagramSocket;
	public ReceiveData(DatagramSocket datagramSocket) {
		super();
		datagramSocket=this.datagramSocket;

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			byte[] buf=new byte[1024];
			
			//�������ݰ�
			DatagramPacket datagramPacket=new DatagramPacket(buf, buf.length);
			
				//����������û���յ����ݾ�һֱ�ȴ�
			try {
				datagramSocket.receive(datagramPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��������

			String ip = datagramPacket.getAddress().getHostAddress();
			int port = datagramPacket.getPort();
			String data = new String(datagramPacket.getData(),0,datagramPacket.getLength());
			if ("over".equals(data)) {
				System.out.println(ip+"�Ѿ��뿪");
			}

			System.out.println(ip+":"+data);
		}



	}

}








