/**
 * 
 */
package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyuan
 * @date 2018年8月2日下午2:20:31
 * @Description 阻塞队列实现消费者  生产者模型
 */
public class MyArrayBlockingQueue {
	
	private static final ArrayBlockingQueue<Apple> queue=new ArrayBlockingQueue<>(1);
	public static void main(String[] args) {
		 new Thread(new Producer(queue)).start();
	        
	        new Thread(new Consumer(queue)).start();
	}
	
	//生产者
static	class Producer implements Runnable{
		private final ArrayBlockingQueue<Apple> queue;
		/**
		 * 队列初始化
		 */
		public Producer(ArrayBlockingQueue<Apple> queue) {
			// TODO Auto-generated constructor stub
			this.queue=queue;
		}
		public void run() {
			while(true) {
				try {
		            Apple apple = new Apple();
		            queue.put(apple);
		            System.out.println("生产:"+apple);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		}
	}
	//消费者
static	class Consumer implements Runnable{

	    private ArrayBlockingQueue<Apple> mAbq;
	    Consumer(ArrayBlockingQueue<Apple> arrayBlockingQueue){
	        this.mAbq = arrayBlockingQueue;
	    }

	    @Override
	    public void run() {
	        while (true){
	            try {
	                TimeUnit.MILLISECONDS.sleep(1000);
	                Apple apple = mAbq.take();
	    	        System.out.println("消费Apple="+apple);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }   
	}
	
	private static class Apple{
		
	}
}
