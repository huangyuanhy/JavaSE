package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class UpLoad implements Runnable {
	public UpLoad(Socket socket) {
		this.socket=socket;
	}
	InputStream inputStream;
	private Socket socket;	
	@Override
	public void run() {		
		String ip = socket.getInetAddress().getHostAddress();		
		File file = getFile(ip);
		//Files.copy(Paths.get("1.jpg"), new FileOutputStream("2.jpg"));

		try {
			inputStream = socket.getInputStream();
			FileOutputStream fileOutputStream=new FileOutputStream(file);
			byte[] buf=new byte[1024];
			int len=0;
			while ((len=inputStream.read(buf))!=-1) {
				fileOutputStream.write(buf,0,len);
			}
			
			OutputStream outputStream=socket.getOutputStream();
			outputStream.write("上传成功".getBytes());
			
			fileOutputStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static File getFile(String ip) {
		File dir=new File("E:\\servertest");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count=1;
		File file= new File(dir, ip+"("+count+")"+".jpg");
		while (file.exists()) {
			count++;
			file= new File(dir, ip+"("+count+")"+".jpg");
		}
		return file;
	}

}
