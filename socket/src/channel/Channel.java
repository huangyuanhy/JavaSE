/**
 * 
 */
package channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author huangyuan
 * @date 2018年7月30日下午2:26:38
 * @Description
 */
public class Channel {
	public static void main(String[] args) throws Exception{
		RandomAccessFile file=new RandomAccessFile("test.txt", "rw");
		FileChannel channel = file.getChannel();
		ByteBuffer allocate = ByteBuffer.allocate(48);
		int read = channel.read(allocate);
		
		while(read!=-1) {
			allocate.flip();
			while(allocate.hasRemaining()) {
				System.out.println(allocate.get());
			}
			allocate.clear();
			read=channel.read(allocate);
		}
		file.close();
		
	}
}
