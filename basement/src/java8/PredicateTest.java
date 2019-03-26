package java8;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * ʹ��Java8������predicate��������
 * @author Administrator
 *
 */
public class PredicateTest {
	@Test
	public void main() {
		ConcurrentHashMap<String, String> map=new ConcurrentHashMap<>(16);
		Collection<String> books=new HashSet<>();
		books.add("疯狂Java训练营");
		books.add("Java入门知识");
		books.add("从入门到放弃系列的ios");
		books.add("鸟哥的私房菜Linux大全");
		books.add("xml必学知识点汇总");
		
//		books.removeIf(ele ->ele.length()<8);
//		System.out.println(books);
//		System.out.println(callAll(books,ele->ele.contains("Java")));
//		System.out.println(callAll(books,ele->ele.length()>10));
		
		Set<String>  collect = books.stream().map(book->book.concat("-----")).collect(Collectors.toSet());
		System.out.println(collect);
	}

	private int callAll(Collection<String> books,Predicate<String> predicate) {
		int total=0;
		for(String str:books) {
			if (predicate.test(str)) {
				total++;
			}
		}
		return total;
	}
}



