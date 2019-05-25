/**
 * 
 */
package clone;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huangyuan
 * @date 2018年8月8日下午7:31:59
 * @Description
 * 深复制和浅复制的
 * 继承自java.lang.Object类的clone()方法是浅复制，即基本类型复制其值，但是对象只是引用。以下代码可以证明之。
 */
public class ColoneTest implements Cloneable{
	ColoneTest(String name,int age){
		this.name=name;
		this.age=age;
	}
	private int age;
	private List<String> list=new LinkedList<>();
	private String  name=null;
	
	public void test() {
		System.out.println("我是来测试深复制和浅复制的");
	}
	public static void main(String[] args) throws CloneNotSupportedException{
		
		ColoneTest c = new ColoneTest("huangyuan",15);
		
		ColoneTest clone1=(ColoneTest)c.clone();
		//基本类型的值不会覆盖原来的
		clone1.setAge(20);
		clone1.setName("小红");
		
		clone1.test();
		//两个集合对象指向同一个引用。
		c.getList().add("小媛");
		
		System.out.println(clone1.toString());
		System.out.println(c.toString());
		
		
	}
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ColoneTest[年龄："+age+",姓名："+name+",集合"+list+"]";
	}
}
