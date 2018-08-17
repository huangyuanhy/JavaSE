package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Mybook {
	public void before1() {
		System.out.println("前置增强--------");
	}
	public void after1() {
		System.out.println("后置增强--------");
	}
	//环绕通知
	public void around1(ProceedingJoinPoint p) throws Throwable {
		//方法之前
		System.out.println("方法之前的输出--------");
		
		//被增强的方法
		p.proceed();
		
		//方法之后
		System.out.println("方法之前的输出--------");
	}
}
