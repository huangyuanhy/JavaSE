package test;

import java.util.Hashtable;

public class TeatHashtable {
	public static void main(String[] args) {
		Hashtable ht=new Hashtable();
		ht.put(new A(60000), "Struts3Ȩ��ָ��");
		ht.put(new A(87563), "������J2EE��ҵӦ��ʵս");
		ht.put(new A(1232), new B());
		
		System.out.println(ht);
		
		//��ΪB��������κ���ȶ������棬�������淵��true;
		System.out.println(ht.containsValue("�����ַ���"));
		
		//ֻҪ���������count������ȣ���ôequals��hashCodeֵ�����
		System.out .println(ht.containsKey(new A(87563)));
		
		//ɾ�����һ��key-values
		ht.remove(new A(1232));
		
		//ͨ������hashtable��keySet���ϣ��Ӷ�����ÿ��key-values��
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

//��д��A���equals��hashCode ����
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
//B�����κζ�����ȶ�������
class B{
	public boolean equals(Object obj) {
		return true;
	}
}