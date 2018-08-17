package aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		Book bean = context.getBean("book", Book.class);
		bean.add();
	}
}
