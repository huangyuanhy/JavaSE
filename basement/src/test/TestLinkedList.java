package test;

import java.util.*;

public class TestLinkedList {
	public static void main (String[] args) {
		LinkedList books=new LinkedList();
		//������е�β��
		books.offer("Struts2Ȩ��ָ��");
		//�ַ�����ջ
		books.push("������J2EE��ҵӦ��ʵս");
		//��ӵ����е�ͷ��
		books.offerFirst("ROR���ݿ������ʵս");
		System.out.println("����Ԫ��");
		for(int i=0;i<books.size();i++) {
			System.out.println(books.get(i));
		}
		//���ʡ�����ɾ�����е����һ��Ԫ��
		System.out.println(books.peekFirst());
		//���ó��C��ʽ����һ��Ԫ��pop��ȥ,���ҷ��ظ�ֵ
		System.out.println(books.pop());
		System.out.println(books);
		
		//���ʲ�ɾ�����е����һ��Ԫ��
		System.out.println(books.pollLast());
		
	}
}
