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

	/**服务器端接受文本数据 并回显“上传成功”字样
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("服务启动");
		// TODO Auto-generated method stub
		//服务器端对象
		ServerSocket serverSocket=new ServerSocket(10006);
		//获取客户端对象
		Socket socket=serverSocket.accept();
		
		System.out.println(socket.getInetAddress().getHostAddress()+"is connected");
		//获取读取流 确定源 网络socket
		BufferedReader bufin=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//确定目的  文件
		PrintWriter pWriter=new PrintWriter(new FileWriter("server.txt"),true);
		
		//读写
		String line=null;
		while ((line=bufin.readLine())!=null) {
			/*//这个标记十分很重要，不然双方阻塞
			if ("over".equals(line)) {
				break;
			}*/
			
			pWriter.println(line);

		}
		
		//给客户端返回信息
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		out.println("上传成功");
		
		//关闭连接
		out.close();
		socket.close();
		serverSocket.close();
		
		
		
	}

}
