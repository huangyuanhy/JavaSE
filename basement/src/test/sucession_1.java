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
		super("����",24,"ѧʿ");
		System.out.println("����"+name+"\t����"+age+"\tѧλ"+degree+ "\tרҵ:"+specality);
	}
}
class Graduate extends Student_1{
	Graduate(String direction){
		super("����",27,"˶ʿ");
		 String s="����"+name+"\t����"+age+"\tѧλ"+degree+"\tרҵ:"+direction; 
		 System.out.println(s);
	}
}
public class sucession_1 {
	public static void main(String args[]) {
		Undergraduate p=new Undergraduate("�����");
		Graduate a=new Graduate("���Ͽ�ѧ");
	}
}
