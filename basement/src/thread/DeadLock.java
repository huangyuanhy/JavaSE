package thread;

public class DeadLock implements Runnable {
		A a=new A();
		B b=new B();
		public void init() {
			Thread.currentThread().setName("���߳�");
			a.foo(b);
			System.out.println("�������߳�֮��");
		}
	
	public void run() {
		Thread.currentThread().setName("���߳�");
		b.bar(a);
		System.out.println("���븱�߳�֮��");
	}
	public static void main(String[] args) {
		DeadLock d1=new DeadLock();
		
		new Thread(d1).start();
		d1.init();
	}
	
}
class A{
	public  synchronized void foo(B b){
		System.out.println(Thread.currentThread().getName()+"����Aʵ����foo����");
		try {
			Thread.sleep(2000);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"��ͼ����Bʵ����last����");
		b.last();
	}
	public  synchronized void last() {
		System.out.println("������A���last�����ڲ�");
	}
}
class B{
	public  synchronized void bar(A a) {
		System.out.println(Thread.currentThread().getName()+"����Bʵ����bar����");
		try {
			Thread.sleep(2000);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"��ͼ����Aʵ����last����");
		a.last();
		
	}
	public  synchronized void last() {
		System.out.println("������B���last�����ڲ�");
	}
	
	
}