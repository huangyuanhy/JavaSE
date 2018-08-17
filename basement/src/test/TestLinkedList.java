package test;

import java.util.*;

public class TestLinkedList {
	public static void main (String[] args) {
		LinkedList books=new LinkedList();
		//加入队列的尾部
		books.offer("Struts2权威指南");
		//字符串入栈
		books.push("轻量级J2EE企业应用实战");
		//添加到队列的头部
		books.offerFirst("ROR敏捷开发最佳实战");
		System.out.println("遍历元素");
		for(int i=0;i<books.size();i++) {
			System.out.println(books.get(i));
		}
		//访问、并不删除队列的最后一个元素
		System.out.println(books.peekFirst());
		//采用出桟方式将第一个元素pop出去,并且返回该值
		System.out.println(books.pop());
		System.out.println(books);
		
		//访问并删除队列的最后一个元素
		System.out.println(books.pollLast());
		
	}
}
