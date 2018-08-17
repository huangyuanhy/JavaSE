package test;

import java.util.Hashtable;

public class TeatHashtable {
	public static void main(String[] args) {
		Hashtable ht=new Hashtable();
		ht.put(new A(60000), "Struts3权威指南");
		ht.put(new A(87563), "轻量级J2EE企业应用实战");
		ht.put(new A(1232), new B());
		
		System.out.println(ht);
		
		//因为B类对象与任何相比都返回真，所以下面返回true;
		System.out.println(ht.containsValue("测试字符串"));
		
		//只要两个对象的count属性相等，那么equals和hashCode值都相等
		System.out .println(ht.containsKey(new A(87563)));
		
		//删除最后一个key-values
		ht.remove(new A(1232));
		
		//通过返回hashtable的keySet集合，从而遍历每个key-values对
		for(Object key : ht.keySet())
		{
			System.out.print(key+"--------->");
			System.out.print( ht.get(key)+"\n");
		}
		
//		for(Object obj : ht.entrySet()) {
//			System.out.print(obj.getClass());
//		}
	}
}

//重写了A类的equals和hashCode 方法
class A{
	int count;
	public A() {}
	public A(int count) {
		this.count=count;
	}
	public boolean equals (Object obj) {
		if(obj==this) {
			return true;
			
		}
		if(obj!=null&&obj.getClass()==this.getClass()) {
			A a=(A) obj;
			if(this.count==a.count) {
				return true;
			}
		}
		return false;
		
	}
	public int hashCode() {
		return this.count;
	}
}
//B类与任何对象相比都返回真
class B{
	public boolean equals(Object obj) {
		return true;
	}
}