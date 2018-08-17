package jvm;

public class Jps {
	public static void main(String[] args) {
		while (true) {
			for(int i=0;i<1000;i++) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						byte[] by=new byte[10240];
						System.out.println(Thread.currentThread().getName()+"------");
						
					}
				}).start();
			}
			
		}
	}
}
