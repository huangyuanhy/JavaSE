/**  
* <p>Title: parallelStremAndStream.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: www.360.net</p>  
* @author huangyuan  
* @date 2019年3月6日  
* @version 1.0  
*/  
package java8;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**  
* <p>Title: parallelStremAndStream</p>  
* <p>Description: 比较并行流与普通流</p>  
* @author huangyuan  
* @date 2019年3月6日  
*/
public class parallelStremAndStream {
	private final static long PERSON_NUMBER=50000;//分别测试500,50000,5000000
 
	public static void main(String[] args) {
		List<Person> persons = init();
		for(int i=1;i<=5;i++) {
			System.out.println("-----第"+i+"次循环-------");
			testCommonsCollection(persons);
			testStream(persons);
			testParallelStream(persons);
		}
	}
	//测试普通集合操作效率
	public static void testCommonsCollection(List<Person> persons) {
		long start = System.currentTimeMillis();
		long ageSum=0;
		for (Person person : persons) {
			ageSum+=person.getAge();
		}
		long end = System.currentTimeMillis();
		System.out.println("总的年龄为"+ageSum);
		System.out.println(PERSON_NUMBER+"个对象集合使用普通集合操作一共花费时间："+(end-start)+"ms");
	}
	//测试stream效率
	public static void testStream(List<Person> persons) {
		long start = System.currentTimeMillis();
		Optional<Long> sumAge = persons.stream().map(Person::getAge).reduce((age1,age2)->age1+age2);
		if (sumAge.isPresent()) {
			System.out.println("总的年龄为"+sumAge.get());
		}
		long end = System.currentTimeMillis();
		System.out.println(PERSON_NUMBER+"个对象集合使用stream一共花费时间："+(end-start)+"ms");
	}
	//测试parallel stream效率
	public static void testParallelStream(List<Person> persons) {
		long start = System.currentTimeMillis();
		Optional<Long> sumAge = persons.parallelStream().map(Person::getAge).reduce((age1,age2)->age1+age2);
		if (sumAge.isPresent()) {
			System.out.println("总的年龄为"+sumAge.get());
		}
		long end = System.currentTimeMillis();
		System.out.println(PERSON_NUMBER+"个对象集合使用parallel stream一共花费时间："+(end-start)+"ms");
	}
	public static List<Person> init(){
		List<Person> persons=new LinkedList<Person>();
		for(int i=1;i<=PERSON_NUMBER;i++) {
			Person person = new Person();
			person.setId(String.valueOf(i));
			person.setAge(i);
			persons.add(person);
		}
		return persons;
	}
}
