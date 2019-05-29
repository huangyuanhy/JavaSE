/**
 * 
 */
package clone;


/**
 * @author pc
 *采用序列化机制实现深克隆
 */
public class DeepColneDemo {

	public static void main(String[] args) throws Exception {
		//serializeClone();
		superClone();
	}
	//采用序列化机制实现深克隆
	public static void serializeClone() throws Exception {
		Teacher teacher=new Teacher();
		teacher.setName("小红");
				
		Student student=new Student();
		student.setAge(20);
		student.setName("小明");
		student.setTeacher(teacher);
				
		Student s2 =(Student) student.deepColne();
		System.out.println(s2==student);//通过序列化的方式，已经和原来不是同一个对象了
		s2.getTeacher().setName("james");
		System.out.println(student);
		System.out.println(s2);
	}
	//引用对象也实现clone，引用封装层级较多时不适用
	public static void superClone() throws CloneNotSupportedException {
		Teacher2 teacher=new Teacher2();
		teacher.setName("小红");
				
		Student2 student=new Student2();
		student.setAge(20);
		student.setName("小明");
		student.setTeacher(teacher);
		
		Student2 s2 = (Student2)student.clone();
		
		s2.getTeacher().setName("james");
		System.out.println(student);
		System.out.println(s2);
	}

}
