package test;

import java.util.*;
import java.util.Map.Entry;

public class TreeMapTest  	extends TreeMap{
	public static void main(String[] args) {
		/*TreeMap<Object, Object> treeMap = new TreeMap<>();//基本类型和String类型都可以进行自然排序。其他的自定义类型需要实现comparablek接口
		treeMap.put("1", 42341);
		treeMap.put("3", 42341);
		treeMap.put("2", 42341);
		treeMap.put("4", 42341);
		Set<Entry<Object, Object>> entrySet = treeMap.entrySet();
		for(Entry<Object, Object> map:entrySet) {
			System.out.println(map.getKey()+"----"+map.getValue());
		}*/
		TreeMapTest tm=new TreeMapTest();
		tm.put(new R(3),"fasdfasf");
		tm.put(new R(-5),"Stuts2");
		tm.put(new R(9),"Rfdasfsafa");
		System.out.println(tm);
	
		//���ص�һ��Entry����
		System.out.println(tm.firstEntry());
		
		//�������һ��Key ֵ
		System.out.println(tm.lastKey());
		
		//����key-1 �� 4֮���key-valueֵ
		System.out.println(tm.subMap(new R(-1),new R(4)));
		
		//���ط��ر�key2 �����Сֵ
		System.out.println(tm.higherKey(new R(2)));
	}
}
//R��  ��д��equals,compareTo ����
class R implements Comparable{
	int count ;
	public R(int count) {
		this.count =count;
		
	}
	public String toString() {
		return "R(count"+count+")";
	}
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if(obj!=null&&obj.getClass()==R.class) {
			R r=(R)obj;
			if(r.count==this.count) {
				return true;
			}
		}
		return false;
	}
	public int compareTo(Object obj) {
		R r=(R)obj;
		if(this.count>r.count) {
			return 1;
		}
		if(this.count==r.count) {
				return 0;
		}
		else {
					return -1;
		}
	}
}