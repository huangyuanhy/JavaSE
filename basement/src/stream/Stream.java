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
//应用stream流对集合set进行操作，使用到 predicate 函数式接口--------------------
public class Stream {
	public static void main(String[] args) throws Exception{
		//构造流
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
		books.add("轻量级javaee 企业应用实战");
		books.add("疯狂java讲义");
		books.add("疯狂ios讲义");
		books.add("轻疯狂ajax讲义");
		books.add("疯狂Android软件");
		
		
		//removeIf(Predicate filter)方法，批量删除符合filter条件的所有方法
		books.removeIf(ele->ele.length()>10);
		System.out.println(books);
		
		//统计书名中出现疯狂字符串的图书数量
		System.out.println(books.stream().filter(ele ->ele.contains("疯狂")).count());   //3
		//统计出现Java字符串图书数量
		System.out.println(books.stream().filter(ele ->ele.contains("java")).count());//1

		//统计书名长度大于10的图书数量
		System.out.println(books.stream().filter(ele ->ele.length()>10).count());
*/
		
		
	/*	
		//-----------------------------------------下面是list 集合的操作----------------
		ArrayList<String > list=new ArrayList<String >();
		list.add("轻量级javaee 企业应用实战");
		list.add("疯狂java讲义");
		list.add("疯狂ios讲义");
		list.add("轻疯狂ajax讲义");
		list.add("疯狂Android软件");
		//使用目标类型为Comparator 的lambda表达式对其进行排序
		list.sort((o1,o2)->o1.length()-o2.length());//sort方法是arraylist独有的方法。所以需要强转
		System.out.println( list.get(0));//取出最小的一个
	*/
		
		
	}
}
