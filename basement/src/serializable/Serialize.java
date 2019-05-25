/**
 * 
 */
package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author pc
 *序列化和反序列化测试
 */
public class Serialize {

	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setAdress("成都");
		person.setName("小明");
		Person.age=26;
		serializePerson(person);
		deserializePerson();

	}
	public static void serializePerson(Person person) throws Exception {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("person")));
		oos.writeObject(person);
		oos.flush();
		System.out.println("第一次序列化成功,大小为"+new File("person").length());
		
		//通过查看person二进制文件可知，只是最后追加了5个字节的引用
		person.setName("小红");//反序列化后的名字并没有改变
		oos.writeObject(person);
		System.out.println("第二次序列化成功,大小为"+new File("person").length());
		oos.close();
	}
	
	public static void deserializePerson() throws Exception {
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("person")));
		Person person = (Person)ois.readObject();//反序列化的时候会根据构造器生成新的对象
		Person person1 = (Person)ois.readObject();
		//Person person2 = (Person)ois.readObject();//序列化几次，则最多反序列化几次，否则报错 java.io.EOFException
		//当写入文件的为同一对象时，并不会再将对象的内容进行存储，而只是再次存储一份引用，上面增加的 5 字节的存储空间就是新增引用和一些控制信息的空间。
		System.out.println("两个对象是否是同一个："+(person==person1));//true
		Person.age=30;
		System.out.println("反序列化结果"+person);//Person [name=小明, adress=null]
		System.out.println("年龄："+Person.age);
	}

}
