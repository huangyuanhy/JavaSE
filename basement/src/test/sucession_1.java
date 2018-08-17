package test;
class Student_1{
	String name;
	int age;
	String degree;
	Student_1(String name,int age,String degree){
		this.name=name;
		this.age=age;
		this.degree=degree;
	}
}
class Undergraduate extends Student_1{
	Undergraduate(String specality){
		super("张三",24,"学士");
		System.out.println("姓名"+name+"\t年龄"+age+"\t学位"+degree+ "\t专业:"+specality);
	}
}
class Graduate extends Student_1{
	Graduate(String direction){
		super("李四",27,"硕士");
		 String s="姓名"+name+"\t年龄"+age+"\t学位"+degree+"\t专业:"+direction; 
		 System.out.println(s);
	}
}
public class sucession_1 {
	public static void main(String args[]) {
		Undergraduate p=new Undergraduate("计算机");
		Graduate a=new Graduate("材料科学");
	}
}
