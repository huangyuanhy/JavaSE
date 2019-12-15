package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;


public class TraderTest {
	/**
	 * 练习对集合的流式操作的综合练习，也是开发中常用的技巧，用好了事倍功半
	 * 有点类似sql语句的操作
	 * 1. 找出2011年发生的所有交易额度，并按交易额排序
	 * 2. 交易员都在哪些不同的城市工作过
	 * 3. 查找来自剑桥的所有的交易员,并按姓名排序
	 * 4. 有没有交易员是在米兰工作的
	 * 5. 打印所有在剑桥的交易员的所有交易总额
	 * 6. 所有交易额中最小的交易是多少
	 * 7. 所有交易额中最高的交易是多少
	 * 8. 找到交易额最小的交易
	 */
	private List<Transaction> list;
	@Before
	public void init() {
		Trader raloul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		list=Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raloul, 2012, 1000),
				new Transaction(raloul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
				
	}
	// 找出2011年发生的所有交易额度，并按交易额排序
	@Test
	public void transaction1() {
		 list.stream()
		 .filter((e)->e.getYear()==2011)
		 .sorted((t1,t2)->Integer.compare(t1.getDeal(), t2.getDeal()))
		 .forEach(System.out::println);
	}
	// 交易员都在哪些不同的城市工作过
	@Test
	public void transaction2() {
		list.stream()
		.map(t->t.getTrader().getAddress())
		.distinct()
		.forEach(System.out::println);
	}
	// 查找来自剑桥的所有的交易员,并按姓名排序
	@Test
	public void transaction3() {
		list.stream()
		.filter(t->t.getTrader().getAddress().equals("Cambridge"))
		.map(t->t.getTrader().getName())
		.sorted()
		.forEach(System.out::println);
	}
	//有没有交易员是在米兰工作的
	@Test
	public void transaction4() {
		boolean b = list.stream()
		.anyMatch(t->t.getTrader().getAddress().equals("Milan"));
	}
	
	//打印所有在剑桥的交易员的所有交易总额
	@Test
	public void transaction5() {
		 Optional<Integer> reduce = list.stream()
		.filter(t->t.getTrader().getAddress().equals("Cambridge"))
		.map(Transaction::getDeal)
		.reduce(Integer::sum);
		System.out.println(reduce.get());
	}
	//所有交易额中最小的交易是多少
	@Test
	public void transaction6() {
		list.stream()
		.map(t->t.getDeal())
		.sorted()
		.limit(1)
		.forEach(System.out::println);
	}
	//所有交易额中最高的交易是多少
	@Test
	public void transaction7() {
		Optional<Integer> max = list.stream()
		.map(t->t.getDeal())
		.max(Integer::compare);
		System.out.println(max.get());
	}
	//找到交易额最小的交易
	@Test
	public void transaction8() {
		Optional<Transaction> min = list.stream()
				.min((t1,t2)->Integer.compare(t1.getDeal(), t2.getDeal()));
		System.out.println(min.get());
	}
}
