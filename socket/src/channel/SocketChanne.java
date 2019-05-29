/**
 * 
 */
package channel;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author huangyuan
 * @date 2018年8月1日上午10:40:14
 * @Description
 */
public class SocketChanne {
	public static void main(String[] args) throws Exception{
		SocketChannel open = SocketChannel.open();
		//设为非阻塞模式
		open.configureBlocking(false);
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.put("hello".getBytes());
		int read = open.read(buf);
		
	}
}
