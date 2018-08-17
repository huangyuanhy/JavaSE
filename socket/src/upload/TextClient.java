/**
 * 
 */
package upload;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Administrator
 *
 */
public class TextClient {

	/**
	 * @param args
	 * @throws Exception 
	 * 
	 */
	public static void main(String[] args) throws  Exception {
		// TODO Auto-generated method stub
		System.out.println("客户端启动");
		//客户端socket
		Socket socket=new Socket("192.168.1.55",10006);
		//确定数据源 即本地文件
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		//确定目的   即socket输出流
	//	BufferedWriter bWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		
		//写数据
		String line=null;
		while ((line=br.readLine())!=null) {
			out.println(line);
		}
		//结束标记      特别重要，否则双方会阻塞
		/*out.println("over");*/
		//此方法实际是向服务器发送一个结束标记
		socket.shutdownOutput();
		
		
		//返回服务器端的信息
		BufferedReader bin=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String readLine = bin.readLine();
		System.out.println(readLine);
		
		//关闭
		bin.close();
		socket.close();
	}

}
