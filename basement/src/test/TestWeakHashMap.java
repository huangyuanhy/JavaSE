package test;

import java.util.WeakHashMap;

public class TestWeakHashMap {
	public static void main(String[] args) {
		WeakHashMap<String, String> whm=new WeakHashMap<String, String>();
		//���������ַ�����û����������
		whm.put(new String("����"),new String("����"));
		whm.put(new String("��ѧ"),new String("����"));
		whm.put(new String("Ӣ��"),new String("�е�"));
		
		//���һ��ϵͳ������ַ�������
		whm.put("java",new String("����"));
		
		System.out.println(whm);
		
		//֪ͨϵͳ������������
		System.gc();
		System.runFinalization();
		
		//ͨ�������ֻ��һ��Key-value ��
		System.out.println(whm);
	}
}
