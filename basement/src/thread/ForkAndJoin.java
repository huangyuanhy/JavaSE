/**
 * 
 */
package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author huangyuan
 * @date 2018年8月31日上午8:35:58
 * @Description 测试forkandjoin 分而治之的思想
 */
public class ForkAndJoin {

	/**
	 * @param args
	 * @Description TODO
	 */
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		Long sum = forkJoinPool.invoke(new Task(1L,1000000000L));
		
		System.out.println(sum);
		long e = System.currentTimeMillis();
		System.out.println("共花费"+(e-s)+"秒");
	}
	
	
}
/**
 * @author huangyuan
 * @date 2018年8月31日上午8:37:09
 * @Description   RecursiveAction或者是RecursiveTask，这个两个都是抽象类，有一个抽象方法compute()，
 * 他们之间的区别在于，前者是没有返回值的，后者是有返回值的，有点像是Runnable和Callable的关系。
 */
class Task extends RecursiveTask<Long>{
	private Long start;
	private Long end;
	private static final Long THRESHOLD=1000L;//临界值
	
	public Task(Long start, Long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
		if (end-start<THRESHOLD) {
			Long sum=0L;
			for(long i=start;i<end;i++) {
				sum+=i;
			}
			return sum;
		}else {
			long mid=(start+end)/2;
			Task task1 = new Task(start, mid);
			task1.fork();
			
			Task task2 = new Task(mid+1, end);
			task2.fork();
			return task1.join()+task2.join();
		}
		
	}
	
}
class Fibonacci extends RecursiveTask<Integer> {
	   final int n;
	   Fibonacci(int n) { this.n = n; }
	
	   protected Integer compute() {
	     if (n <= 1)
	       return n;
	     Fibonacci f1 = new Fibonacci(n - 1);
	     f1.fork();
	     Fibonacci f2 = new Fibonacci(n - 2);
	     return f2.compute() + f1.join();
	   }
	 }
