/**
 * 
 */
package upload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 *
 */
public class TextSErver {

	/**�������˽����ı����� �����ԡ��ϴ��ɹ�������
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("��������");
		// TODO Auto-generated method stub
		//�������˶���
		ServerSocket serverSocket=new ServerSocket(10006);
		//��ȡ�ͻ��˶���
		Socket socket=serverSocket.accept();
		
		System.out.println(socket.getInetAddress().getHostAddress()+"is connected");
		//��ȡ��ȡ�� ȷ��Դ ����socket
		BufferedReader bufin=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//ȷ��Ŀ��  �ļ�
		PrintWriter pWriter=new PrintWriter(new FileWriter("server.txt"),true);
		
		//��д
		String line=null;
		while ((line=bufin.readLine())!=null) {
			/*//������ʮ�ֺ���Ҫ����Ȼ˫������
			if ("over".equals(line)) {
				break;
			}*/
			
			pWriter.println(line);

		}
		
		//���ͻ��˷�����Ϣ
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("�ϴ��ɹ�");
		
		//�ر�����
		out.close();
		socket.close();
		serverSocket.close();
		
		
		
	}

}
