package clone;

public class Student2 implements Cloneable{
	private String name;
	private int age;
	private Teacher2 teacher;
	 
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student2 clone = (Student2)super.clone();
		clone.setTeacher((Teacher2)teacher.clone());
		return (Student2)clone;
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
	public Teacher2 getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher2 teacher) {
		this.teacher = teacher;
	}
}
