package test;
abstract class Demo{
	public abstract void function();
	 final void costTime() {
		long A=System.currentTimeMillis();
		function();
		long B=System.currentTimeMillis();
		long C=B-A;
		System.out.println("¹²»¨·Ñ"+C);
	}
}
class test extends Demo{
	public static String text;

	public void function(){
	for(int i=0;i<100;i++) {
		System.out.println(i);
		}	
	}
}
public class Costtime {
	public static void main(String args[]) {
		Demo f=new test();
		f.costTime();
		}
}
