package test;

//Collections 工具类来操作set list map 集合类 ，可进行排序，查询进和修改等操作

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
		
		//元素反转
		Collections.reverse(nums);
		System.out.println(nums);
		
		//自然排排序
		Collections.sort(nums);
		System.out.println(nums);
		
		//重新洗牌
		Collections.shuffle(nums);
		System.out.println(nums);
	
	}
}
