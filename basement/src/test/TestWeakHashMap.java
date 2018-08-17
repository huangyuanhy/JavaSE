package test;

import java.util.WeakHashMap;

public class TestWeakHashMap {
	public static void main(String[] args) {
		WeakHashMap<String, String> whm=new WeakHashMap<String, String>();
		//匿名对象字符串，没有其他引用
		whm.put(new String("语文"),new String("及格"));
		whm.put(new String("数学"),new String("良好"));
		whm.put(new String("英文"),new String("中等"));
		
		//添加一个系统缓存的字符串对象
		whm.put("java",new String("优秀"));
		
		System.out.println(whm);
		
		//通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		
		//通常情况下只有一个Key-value 对
		System.out.println(whm);
	}
}
