/**
 * 
 */
package thread;

/**
 * @author huangyuan
 * @date 2018年8月19日上午9:35:00
 * @Description
 */
public class CountDownLatch {
	public static void main(String[] args) {
		java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(5);
		new Thread(()->{
			System.out.println("准备下班");
			try {
				countDownLatch.await();
				System.out.println("他们走完了，我终于能走了");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}) .start();;
		
		for(int i=0; i<5;i++) {
			new Thread(()->{
				System.out.println("技术员"+Thread.currentThread().getName()+"走了");
				countDownLatch.countDown();
			}).start();
		}
		
	}
}
