package stream;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import files.Paths;
//Ӧ��stream���Լ���set���в�����ʹ�õ� predicate ����ʽ�ӿ�--------------------
public class Stream {
	public static void main(String[] args) throws Exception{
		//������
		// 1. Individual values
		
		Stream stream = null;
		String [] strArray = new String[] {"a", "b", "c"};
		//stream = Stream.of(strArray);
		stream = (Stream) Arrays.stream(strArray);
		// 3. Collections
		List<String> list = Arrays.asList(strArray);
		stream = (Stream) list.stream();
		
				IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
				IntStream.range(1, 3).forEach(System.out::println);
				IntStream.rangeClosed(1, 3).forEach(System.out::println);
			
		
		/*Collection<String> books=new HashSet<String >();
		books.add("������javaee ��ҵӦ��ʵս");
		books.add("���java����");
		books.add("���ios����");
		books.add("����ajax����");
		books.add("���Android���");
		
		
		//removeIf(Predicate filter)����������ɾ������filter���������з���
		books.removeIf(ele->ele.length()>10);
		System.out.println(books);
		
		//ͳ�������г��ַ���ַ�����ͼ������
		System.out.println(books.stream().filter(ele ->ele.contains("���")).count());   //3
		//ͳ�Ƴ���Java�ַ���ͼ������
		System.out.println(books.stream().filter(ele ->ele.contains("java")).count());//1

		//ͳ���������ȴ���10��ͼ������
		System.out.println(books.stream().filter(ele ->ele.length()>10).count());
*/
		
		
	/*	
		//-----------------------------------------������list ���ϵĲ���----------------
		ArrayList<String > list=new ArrayList<String >();
		list.add("������javaee ��ҵӦ��ʵս");
		list.add("���java����");
		list.add("���ios����");
		list.add("����ajax����");
		list.add("���Android���");
		//ʹ��Ŀ������ΪComparator ��lambda���ʽ�����������
		list.sort((o1,o2)->o1.length()-o2.length());//sort������arraylist���еķ�����������Ҫǿת
		System.out.println( list.get(0));//ȡ����С��һ��
	*/
		
		
	}
}
