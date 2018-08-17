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
 * 通过数据接收和发送实现一个聊天工具 采用多线程实现
 * @author Administrator
 *
 */
public class Chat {
	@Test
	public void test() throws IOException {
		//发送端
		DatagramSocket send=new DatagramSocket(8888);
		//接收端
		DatagramSocket receive=new DatagramSocket(12345);
		//开启线程
		new Thread(new SendData(send)).start();
		new Thread(new ReceiveData(receive)).start();
	}


}
//数据发送端
class SendData implements Runnable{
	private DatagramSocket datagramSocket;
	public SendData(DatagramSocket datagramSocket) {
		datagramSocket=this.datagramSocket;
	}

	@Override
	public void run() {

		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		try {
			//定义数据
			String string=null;
			while ((string=bufferedReader.readLine()) != null) {
				if ("over".equals(string)){
					break;
				}
				//封装
				byte[] bytes = string.getBytes();
				DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length,InetAddress.getByName("192.168.1.55"),12345);
				//发送
				datagramSocket.send(datagramPacket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}


//数据接收端
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
			
			//创建数据包
			DatagramPacket datagramPacket=new DatagramPacket(buf, buf.length);
			
				//阻塞方法，没有收到数据就一直等待
			try {
				datagramSocket.receive(datagramPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//解析数据

			String ip = datagramPacket.getAddress().getHostAddress();
			int port = datagramPacket.getPort();
			String data = new String(datagramPacket.getData(),0,datagramPacket.getLength());
			if ("over".equals(data)) {
				System.out.println(ip+"已经离开");
			}

			System.out.println(ip+":"+data);
		}



	}

}








