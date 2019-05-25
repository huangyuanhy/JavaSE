package serializable;

import java.io.Serializable;
/**
 * 父类如果没有实现序列化接口，则其父类属性不会被保存在子类中，要想将父类对象也序列化，
 * 就需要让父类也实现Serializable 接口。如果父类不实现的话的，就需要有默认的无参的构造函数。
 * 而一个 Java 对象的构造必须先有父对象，才有子对象，反序列化也不例外。所以反序列化时，为了构造父对象，只能调用父类的无参构造函数作为默认的父对象。
 * 在父类无参构造函数中对变量进行初始化。
 */
public class Person implements Serializable{//序列化只保存对象的状态，和类状态无关
	private static final long serialVersionUID = 1L;//唯一标识该对象，如果序列化后对此值修改，反序序列化时报错，类似单向加密
	private String name;
	public static int age;//序列化并不保存静态变量
	private transient String adress;//transient 变量不序列化
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", adress=" + adress + "]";
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		Person.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
