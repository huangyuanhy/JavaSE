package ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.PropertyTest;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		
		//得到配置文件的duixiang
		/*User user=(User) context.getBean("user");
		user.add();*/
		Service service =  (Service) context.getBean("service");
		service.service();
	}
	 
}
