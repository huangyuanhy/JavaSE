package java8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;
/**
 * 利用fork and join来切分子任务，并行运算，提高效率 
 * @author woniuyi
 *
 */
public class ForkAndJoin extends RecursiveTask<Long>{
	private static final long serialVersionUID = 1L;
	private long start;
	private long end;
	private static final long THRESHOLD=1000;
	
	public ForkAndJoin(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		if(end-start<=THRESHOLD) {
			long sum=0;
			while(start<=end) {
				sum+=start++;
			}
			return sum;
		}else {
			long middle=(start+end)/2;
			ForkAndJoin left = new ForkAndJoin(start, middle);
			ForkAndJoin right = new ForkAndJoin(middle+1, end);
			left.fork();//拆分子任务
			right.fork();
			return left.join()+right.join();
			
		}
	}
	public static void main(String[] args) {
		ForkJoinPool pool=new ForkJoinPool();
		ForkJoinTask<Long> test = new ForkAndJoin(0, 10000000l);
		Long sum = pool.invoke(test);
		System.out.println(sum);
		
		//java 1.8以后的优化如下:
		long reduce = LongStream.range(0, 10000000l)
		.parallel()//转为并行流
		.reduce(0, Long::sum);
		System.out.println(reduce);
		
	}

}
