package test;
class Cat{
	String name;
	int age;
	String color;
	public String set(String name, String age,String color){
		return "����"+name+"����"+age+"��ɫ"+color;
	}
}
public class this_1 {
	public static void main(String[] args) {
		Cat one=new Cat();
		String A=one.set("\t��һֻè\t","\t5\t","\t��ɫ");
		System.out.println(A);
		//System.out.println(one.set("\t��һֻè\t","\t5\t","\t��ɫ"));
	}
}
