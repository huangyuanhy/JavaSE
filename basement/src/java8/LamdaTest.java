package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.Test;

import test.insert;
import test.return_1;

/**
 * Consumer<T> 消费性接口
 * 	void accept(T t)
 * 
 * Supplier<T> 供给型接口
 * 	T get()
 * 
 * Function<T,R> 函数式接口
 *  R apply(T t)
 *  
 * Predicate<T> 断言型接口
 * 	boolean test(T t)
 * @author pc
 *
 */
public class LamdaTest {
	List<Integer> list = Arrays.asList(1,1,2,4,4,6);
	
	public void testGroup() {
	}
	
	@Test
	public void testReduce() {
		Integer reduce = list.stream().reduce(0,(x,y)->x+y);
		System.out.println(reduce);
	}
	
	
	@Test
	public void testPredicate() {
		int res = predicate("123456", (str)->str.contains("123"));
		System.out.println(res);
	}
	
	public void tesFunction() {
		String function = function("i am happy", (strOrigin)->strOrigin.substring(2));
		System.out.println(function);
	}

	public void testSupply() {
		 List<Integer>  res=supply(10, ()->(int)(Math.random()*1000));
	}
	
	public void testConsume() {
		consume(1000, money->System.out.println("consume money:"+money));
	}
	/**
	 * 断言型接口
	 * @param str
	 * @param predicate 
	 * @return 符合条件1 否则 0
	 */
	public int predicate(String str,Predicate<String> predicate) {
		if( predicate.test(str)) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * 函数式接口
	 * @param str
	 * @param function 对str 进行具体的处理函数
	 * @return 处理后的字符
	 */
	public String function(String str,Function<String, String> function) {
		return function.apply(str);
	}
	
	public List<Integer> supply(Integer num,Supplier<Integer> supplier) {
		List<Integer> res=new ArrayList<Integer>();
		for (int i = 0; i <num; i++) {
			Integer integer = supplier.get();
			res.add(integer);
		}
		return res;
	}
	public void consume(double money,Consumer<Double> consumer) {
		consumer.accept(money);
	}

}
