package test;

import java.util.EnumMap;
//EnumMapö�����ʵ��
public class TestEnumMap {
	public static void main(String[] args) {
		//����һ��EnumMap������keyֵ������Season��ö�����ֵ
		EnumMap enumMap=new EnumMap(Season.class);
		enumMap.put(Season.SPRING,"��������");
		enumMap.put(Season.WINTER,"��ѩ����");
		enumMap.put(Season.FALL,"��Ҷ����");
		System.out.println(enumMap);
	}
}
enum Season{
	SPRING,SUMER,FALL,WINTER;
}