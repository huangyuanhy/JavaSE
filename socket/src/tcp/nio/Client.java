package tcp.nio;

import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 基于 NIO 的 TCP 通信
NIO 主要原理及使用
NIO 采取通道（Channel）和缓冲区(Buffer)来传输和保存数据，它是非阻塞式的 I/O，即在等待连接、读写数据
（这些都是在一线程以客户端的程序中会阻塞线程的操作）的时候，程序也可以做其他事情，以实现线程的异步操作。

考虑一个即时消息服务器，可能有上千个客户端同时连接到服务器，但是在任何时刻只有非常少量的消息需要读取和分发
（如果采用线程池或者一线程一客户端方式，则会非常浪费资源），这就需要一种方法能阻塞等待，直到有一个信道可以进行 I/O 操作。
NIO 的 Selector 选择器就实现了这样的功能，一个 Selector 实例可以同时检查一组信道的 I/O 状态，它就类似一个观察者，
只要我们把需要探知的 SocketChannel 告诉 Selector,我们接着做别的事情，当有事件（比如，连接打开、数据到达等）发生时，
它会通知我们，传回一组 SelectionKey,我们读取这些 Key,就会获得我们刚刚注册过的 SocketChannel,然后，
我们从这个 Channel 中读取数据，接着我们可以处理这些数据。

Selector 内部原理实际是在做一个对所注册的 Channel 的轮询访问，不断的轮询(目前就这一个算法)，
一旦轮询到一个 Channel 有所注册的事情发生，比如数据来了，它就会读取 Channel 中的数据，并对其进行处理。

要使用选择器，需要创建一个 Selector 实例，并将其注册到想要监控的信道上（通过 Channel 的方法实现）。
最后调用选择器的 select()方法，该方法会阻塞等待，直到有一个或多个信道准备好了 I/O 操作或等待超时，
或另一个线程调用了该选择器的 wakeup()方法。现在，在一个单独的线程中，通过调用 select()方法，就能检查多个信道是否准备好进行 I/O 操作，
由于非阻塞 I/O 的异步特性，在检查的同时，我们也可以执行其他任务。
 *
 */
public class Client {
	public static void main(String args[]) throws Exception{  
      /*  if ((args.length < 2) || (args.length > 3))   
        throw new IllegalArgumentException("参数不正确");  
        //第一个参数作为要连接的服务端的主机名或IP  
        String server = args[0];   
        //第二个参数为要发送到服务端的字符串  
        byte[] argument = args[1].getBytes();  
        //如果有第三个参数，则作为端口号，如果没有，则端口号设为7  
        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7; */ 
		String server="localhost";
		int servPort=8888;
		byte[] argument="nihao pengyou".getBytes();
        //创建一个信道，并设为非阻塞模式  
        SocketChannel clntChan = SocketChannel.open();  
        clntChan.configureBlocking(false);  
        //向服务端发起连接  
        if (!clntChan.connect(new InetSocketAddress(server, servPort))){  
            //不断地轮询连接状态，直到完成连接  
            while (!clntChan.finishConnect()){  
                //在等待连接的时间里，可以执行其他任务，以充分发挥非阻塞IO的异步特性  
                //这里为了演示该方法的使用，只是一直打印"."  
                System.out.print(".");    
            }  
        }  
        //为了与后面打印的"."区别开来，这里输出换行符  
        System.out.print("\n");  
        //分别实例化用来读写的缓冲区  
        ByteBuffer writeBuf = ByteBuffer.wrap(argument);  
        ByteBuffer readBuf = ByteBuffer.allocate(argument.length);  
        //接收到的总的字节数  
        int totalBytesRcvd = 0;   
        //每一次调用read（）方法接收到的字节数  
        int bytesRcvd;   
        //循环执行，直到接收到的字节数与发送的字符串的字节数相等  
        while (totalBytesRcvd < argument.length){  
            //如果用来向通道中写数据的缓冲区中还有剩余的字节，则继续将数据写入信道  
            if (writeBuf.hasRemaining()){  
                clntChan.write(writeBuf);  
            }  
            //如果read（）接收到-1，表明服务端关闭，抛出异常  
            if ((bytesRcvd = clntChan.read(readBuf)) == -1){  
                throw new SocketException("Connection closed prematurely");  
            }  
            //计算接收到的总字节数  
            totalBytesRcvd += bytesRcvd;  
            //在等待通信完成的过程中，程序可以执行其他任务，以体现非阻塞IO的异步特性  
            //这里为了演示该方法的使用，同样只是一直打印"."  
            System.out.print(".");   
        }  
        //打印出接收到的数据  
        System.out.println("Received: " +  new String(readBuf.array(), 0, totalBytesRcvd));  
        //关闭信道  
        clntChan.close();  
    }  
}
