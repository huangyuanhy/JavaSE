package test;

//Collections ������������set list map ������ ���ɽ������򣬲�ѯ�����޸ĵȲ���

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class TestCollections extends List{
	public static void main(String[] args) {
		ArrayList nums=new ArrayList();
		nums.add(2);
		nums.add(-1);
		nums.add(9);
		nums.add(4);
		System.out.println(nums);
		
		//Ԫ�ط�ת
		Collections.reverse(nums);
		System.out.println(nums);
		
		//��Ȼ������
		Collections.sort(nums);
		System.out.println(nums);
		
		//����ϴ��
		Collections.shuffle(nums);
		System.out.println(nums);
	
	}
}
