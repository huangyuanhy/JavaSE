/**
 * 
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyuan
 * @date 2018年8月2日上午9:04:58
 * @Description  semaphore实现互斥锁
 */
public class SemaphoreMutex {
	private final static Semaphore mutex=new Semaphore(1);
	public static void main(String[] args) {
		ExecutorService pools = Executors.newCachedThreadPool();
		for(int i=0;i<20;i++) {
			final int index=i;
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						mutex.acquire();
						System.out.println(String.format("[Thread-%s]任务id --- %s",
								Thread.currentThread().getId(),index));
	                       TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}finally {
						mutex.release();
						System.out.println(Thread.currentThread().getId()+"---------------release");
					}
				}
			};pools.execute(runnable);
		}pools.shutdown();
		
	}
}
