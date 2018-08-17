/**
 * 
 */
package test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huangyuan
 * @date 2018年8月8日下午7:31:59
 * @Description
 * 深复制和浅复制的
 * 继承自java.lang.Object类的clone()方法是浅复制。以下代码可以证明之。
 */
public class Clone implements Cloneable{
	Clone(String name,int age){
		this.name=name;
		this.age=age;
	}
	private String  name=null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	private int age;
	private List<String> list=new LinkedList<>();
	public void test() {
		System.out.println("我是来测试深复制和浅复制的");
	}
	public static void main(String[] args) throws CloneNotSupportedException{
		
		Clone c = new Clone("huangyuan",15);
		
		Clone clone1=(Clone)c.clone();
		clone1.setAge(20);
		clone1.setName("guowenjing");
		
		clone1.test();
		/*c.setAge(24);
		c.getList().add("guowenjing");
		c.setName("guowenjing");*/
		
		System.out.println(clone1.toString());
		System.out.println(c.toString());
		
		
	}
}
