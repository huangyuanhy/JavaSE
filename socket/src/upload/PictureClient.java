/**
 * Í¼Æ¬ÉÏ´«
 */
package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * @author Administrator
 *
 */
public class PictureClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		Socket socket=new Socket("192.168.1.55", 10008);
		File file=new File("1.jpg");
		FileInputStream fileInputStream=new FileInputStream(file);
		
		OutputStream outputStream=socket.getOutputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while ((len=fileInputStream.read(buf))!=-1) {
			outputStream.write(buf,0,len);
		}
		
		socket.shutdownOutput();
		
		InputStream inputStream=socket.getInputStream();
		byte[] bufin=new byte[1024];
		int lenin=inputStream.read(bufin);
		String string = new String(bufin,0,lenin);
		System.out.println(string);
		
		
		fileInputStream.close();
		socket.close();
	}

}
