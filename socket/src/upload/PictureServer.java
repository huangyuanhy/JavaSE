/**
 * 
 */
package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Administrator
 *
 */
public class PictureServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("·þÎñÆ÷Æô¶¯");
		// TODO Auto-generated method stub
		ServerSocket serverSocket=new ServerSocket(10008);
		
		while (true) {
			Socket socket = serverSocket.accept();			
			new Thread(new UpLoad(socket)).start();
		}
	}
}
