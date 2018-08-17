package test;

import java.util.EnumMap;
//EnumMap枚举类的实例
public class TestEnumMap {
	public static void main(String[] args) {
		//创建一个EnumMap对象，其key值必须是Season类枚举类的值
		EnumMap enumMap=new EnumMap(Season.class);
		enumMap.put(Season.SPRING,"炎炎夏日");
		enumMap.put(Season.WINTER,"白雪皑皑");
		enumMap.put(Season.FALL,"秋叶静美");
		System.out.println(enumMap);
	}
}
enum Season{
	SPRING,SUMER,FALL,WINTER;
}