package test;

public class gre {
	public static void main(String[] args) {
		Student a=new Student();
		a.nationality="�й�";
		System.out.println(a.nationality);
	}
}
class Student{
	String name;
	static String nationality;
}