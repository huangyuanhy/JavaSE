/**
 * 
 */
package test;

/**
 * @author huangyuan
 * @date 2018年8月10日上午9:05:06
 * @Description
 */
public class extendsTest {
    int count = 21;
    public void count() {
        System.out.println(++count);
    }
    public static void main(String args[]) {
        new extendsTest().count();
        new extendsTest().count();
    }
/*public static void main(String[] args) {
	String str=null;
    str.concat("abc");
    str.concat("123");
    System.out.println(str);
}*/
	 
	/*
	    StringBuffer a = new StringBuffer("A"); 
	    StringBuffer b = new StringBuffer("B"); 
	    operator(a, b); 
	    System.out.println(a + "," + b); 
	} 
	public static void operator(StringBuffer x, StringBuffer y) { 
	    x.append(y); y = x; */
	
/*	class A{}

	class B extends A{}

	class C extends A{}

	class D extends B{}

	A obj = new D();

	System.out.println(obj instanceof B);

	System.out.println(obj instanceof C);//错误

	System.out.println(obj instanceof D);

	System.out.println(obj instanceof A);*/

}
