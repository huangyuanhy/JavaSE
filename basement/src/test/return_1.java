package test;
class Dog{
	String name="xiaoming";
	public String print(String n ){
		System.out.println(n);
		return "С��";
	}
}
public class return_1 {
	public static void main(String[] args){
	Dog a=new Dog();
	a.print("С��");
	System.out.println(a.name);
	System.out.println(a.print("С��"));
	}
}