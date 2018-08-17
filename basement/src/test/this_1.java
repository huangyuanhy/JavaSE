package test;
class Cat{
	String name;
	int age;
	String color;
	public String set(String name, String age,String color){
		return "姓名"+name+"年龄"+age+"颜色"+color;
	}
}
public class this_1 {
	public static void main(String[] args) {
		Cat one=new Cat();
		String A=one.set("\t第一只猫\t","\t5\t","\t黑色");
		System.out.println(A);
		//System.out.println(one.set("\t第一只猫\t","\t5\t","\t黑色"));
	}
}
