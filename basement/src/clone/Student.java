package clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private Teacher teacher;
	
	//采用序列化方式实现深度克隆
	public Object deepColne() throws Exception {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);//将对象保存到字节数组流中
		oos.writeObject(this);//写出到字节数组中
		
		ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", teacher=" + teacher + "]";
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
