/**
 * 
 */
package thread;

/**
 * @author huangyuan
 * @date 2018年7月31日下午4:18:12
 * @Description
 */
public class testThread {
	volatile static int number;
	public static void main(String[] args) {
		
		test1();
	}
	
	
	
	
	public static synchronized void test() {
		for(int i=0;i<20;i++) {
			number++;
			System.out.println(number);
			try {
			Thread.sleep(200);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static synchronized void test1() {
		Thread threadA=new Thread(()-> {
			test();
		});
		threadA.start();
		for(int i=0;i<20;i++) {
			number--;
			System.out.println(number);

		}
	}
}
