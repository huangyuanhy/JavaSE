
package java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.security.auth.kerberos.KerberosKey;

/**  
 * <p>Title: ConlectionOperations</p>  
 * <p>Description: 测试Java8 集合的操作</p>  
 * @author huangyuan  
 * @date 2019年3月5日  
 */
public class  CollectionOperation {
	public static void main(String[] args) {
		List<Person> persons = getList();
		//attribute2Collection(persons);
		//filterList(persons);
		//sortList(persons);
		//groupByKey();
		System.out.println(mapDefinition(persons));
		System.out.println(generateMap(persons));
		System.out.println(testJoin(persons));
	}
	// 多级分组 先按id分组 再按年龄分组
	public static void testGroup(List<Person> persons) {
		Map<String, Map<Long, List<Person>>> collect = persons.stream()
				.collect(Collectors.groupingBy(Person::getId,Collectors.groupingBy(Person::getAge)));
	}
	//根据对象不同的属性生成map{key=id ,value=age}
	public static Map<String, Long> mapDefinition(List<Person> persons) {
		Collector<Person, ?, Long> ageCount = Collectors.summingLong(Person::getAge);
		Map<String, Long> defPerson = persons.stream().collect(Collectors.groupingBy(Person::getId,ageCount));//第二个参数必须是个流式集合
		return defPerson;
	}
	//遍历list集合
	public static void iteratList(List<Person> persons) {
		//  符号->左边是传入的参数，右边是具体的业务操作
		persons.forEach(person->System.out.println(person.getName()));
	}

	//遍历map集合
	public static void iteratMap(Map<String,Person> persons) {
		//(id,person)第一个参数就是key ,第二个参数是value，参数名自定义即可
		persons.forEach((id,person)->{
			System.out.println(person.getName()+"的 id 是:"+id);
		});
	}
	//根据条件进行filter过滤，生成新的集合
	public static void filterList(List<Person> persons) {
		List<Person> ageList = persons.stream().filter(person->person.getAge()<=20).collect(Collectors.toList());
		System.out.println(ageList.size());
	}

	//生成新的map集合
	public static Map<String, Long> generateMap(List<Person> persons){
		Map<String, Long> newMap = persons.stream().collect(Collectors.toMap(Person::getId, Person::getAge));
		return newMap ;
	}
	//分区 两个区 满足条件及不满足的 返回map
	public static Map<Boolean, List<Person>> generateMap2(List<Person> persons){
		Map<Boolean, List<Person>> collect = persons.stream().collect(Collectors.partitioningBy(e->e.getAge()>3));
		return collect ;
	}
	//连接
	public static String testJoin(List<Person> persons){
		return persons.stream().map(Person::getName).collect(Collectors.joining(","));
	}
	// 统计属性 平均值  最大值  总和等 支持Long Double int三种数字型
	public void cummunicate(List<Person> persons) {
		LongSummaryStatistics collect = persons.stream().collect(Collectors.summarizingLong(Person::getAge));
		System.out.println(collect.getAverage());
		System.out.println(collect.getSum());
	}


	//排序
	public static void sortList(List<Person> persons) {
		//原来的方法
		//Collections.sort(persons, (o1,o2)->o1.getAge()-o2.getAge());
		//persons.stream().sorted((o1,o2)->o1.getAge()-o2.getAge());
		Set<Person> collect = persons.stream()
				.sorted(Comparator.comparingLong(Person::getAge))
				.collect(Collectors.toSet());
		collect.forEach(p->System.out.println(p.getAge()));

	}

	//根据list 集合中的对象属性-id 生成新的集合
	public static void attribute2Collection(List<Person> persons) {
		//生成list集合 
		//方法1  lambda表达式简洁易懂-推荐
		List<String> idsList_1 = persons.stream().map(Person::getId).collect(Collectors.toList());
		//方法2 
		List<String> idsList_2 = persons.stream().map(new Function<Person, String>() {
			@Override
			public String apply(Person p) {
				return p.getId();
			}
		}).collect(Collectors.toList());
		System.out.println("根据person的id生成的list集合"+idsList_1);
		System.out.println(idsList_1.equals(idsList_2));

		//生成set集合
		Set<String> idsSet = persons.stream().map(Person::getId).collect(Collectors.toSet());
		System.out.println("根据person的id生成的set集合"+idsList_1);
	}

	//根据集合里的属性进行分组，生成map集合
	public static void groupByKey() {
		List<Person> list = getList();
		Person person = new Person();
		person.setId("1");
		person.setName("张三克隆");
		person.setAge(100);
		list.add(person);
		Map<String, List<Person>> groupPerson = list.stream().collect(Collectors.groupingBy(Person::getId));
		groupPerson.forEach((id,persons)->{
			System.out.print("id:"+id+"------");
			persons.forEach(p->System.out.print(p.getName()+"--"));
			System.out.println();
		});
	}


	public static Map<String, List<Person>> getMap() {
		List<Person> persons = getList();
		Map<String, List<Person>> personsMap=new HashMap<String, List<Person>>();
		List<Person> list_1 =new LinkedList<Person>();
		list_1.add(persons.get(0));
		list_1.add(persons.get(1));
		List<Person> list_2 =new LinkedList<Person>();
		list_2.add(persons.get(1));
		list_2.add(persons.get(2));
		personsMap.put("1",list_1);
		personsMap.put("2",list_2);

		return personsMap;
	}
	public static List<Person> getList() {
		Person p1 = new Person();
		p1.setId("1");
		p1.setName("张三");
		p1.setAge(10);
		Person p2 = new Person();
		p2.setId("2");
		p2.setName("李四");
		p2.setAge(0);
		Person p3 = new Person();
		p3.setId("3");
		p3.setName("王五");
		p3.setAge(9);
		List<Person> personsList =new LinkedList<Person>();
		personsList.add(p3);
		personsList.add(p2);
		personsList.add(p1);

		return personsList;
	}

}
class Person{
	private String id;
	private String name;
	private long age;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public long getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
