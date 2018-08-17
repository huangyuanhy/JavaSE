package test;
class Dog{
	String name="xiaoming";
	public String print(String n ){
		System.out.println(n);
		return "小白";
	}
}
public class return_1 {
	public static void main(String[] args){
	Dog a=new Dog();
	a.print("小明");
	System.out.println(a.name);
	System.out.println(a.print("小明"));
	}
}