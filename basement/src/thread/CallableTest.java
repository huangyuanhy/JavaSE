package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
	public static void main (String[] args) {
	
/*		
		new FutureTask<>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int i=0;
				for(;i<10;i++) {
					System.out.println(Thread.currentThread().getName()+i);
				}
				return i;
			}
		});*/
		
		//����callable���󡣲���futuretask���а�װ
		CallableTest test=new CallableTest();
		FutureTask<Integer> ft=new FutureTask<Integer>(
		/*	new Callable() {
				@Override
				public Object call() throws Exception {
						
					}
				}*/
				()->{
					int i=0;
					for(;i<100;i++) {
						System.out.println(Thread.currentThread().getName()+"i��ֵ"+i);
					}
					return i;
					
				}
			);
		
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"i��ֵ"+i);
			if(i==20) {
				new Thread(ft,"�з���ֵ���߳�").start();
			}
			
		}
		//��ȡ���̵߳ķ���ֵ
		try {
			System.out.println("���̵߳ķ���ֵ"+ft.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
