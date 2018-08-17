/**
 * 
 */
package thread;


import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyuan
 * @date 2018年8月1日下午4:05:40
 * @Description
 */
public class MyExecutor extends ThreadPoolExecutor{
	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		System.out.printf("MyExecutor: Going to shutdown.\n");
		
		System.out.printf("MyExecutor: Executed tasks:%d\n",getCompletedTaskCount());
		
		System.out.printf("MyExecutor: Running tasks:%d\n",getActiveCount());
		
		System.out.printf("MyExecutor: Pending tasks:%d\n",getQueue().size());
		
		super.shutdown();

	}
	private ConcurrentHashMap<String , Date> startTime;
	public MyExecutor(int corePoolSize,int maxPoolSize,
			Long keepAliveTime ,TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);
		startTime=new ConcurrentHashMap<>();


	}

}
