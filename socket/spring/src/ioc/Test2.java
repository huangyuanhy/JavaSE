package ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		
		//得到配置文件的duixiang
		/*User user=(User) context.getBean("user");
		user.add();*/
		PropertyTest bean = (PropertyTest) context.getBean("prop");
		bean.test();
	}
	 
}
