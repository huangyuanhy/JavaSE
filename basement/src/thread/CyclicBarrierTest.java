/**
 * 
 */
package thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author huangyuan
 * @date 2018年8月19日上午9:22:18
 * @Description
 */
public class CyclicBarrierTest {
public static void main(String[] args) {
	CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
	
	for(int i=0;i<2;i++) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				if (name.equals("Thread-0")) {
					name ="huangyuan";
				}else {
					name="guowenjing";
				}
				System.out.println(name+"到了春熙路");
				try {
					cyclicBarrier.await();//只有二者都执行了上面的语句才能往下走  即达到一个共同状态
					System.out.println("我们去吃好吃的吧");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}).start();
	}
}
}
