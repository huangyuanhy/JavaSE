package aop.annotion;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	@Test
	public void testdemo() {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		Book bean = (Book) context.getBean("book2");
		bean.add("java", 12.2);
	}
}
