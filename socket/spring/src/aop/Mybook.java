package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Mybook {
	public void before1() {
		System.out.println("ǰ����ǿ--------");
	}
	public void after1() {
		System.out.println("������ǿ--------");
	}
	//����֪ͨ
	public void around1(ProceedingJoinPoint p) throws Throwable {
		//����֮ǰ
		System.out.println("����֮ǰ�����--------");
		
		//����ǿ�ķ���
		p.proceed();
		
		//����֮��
		System.out.println("����֮ǰ�����--------");
	}
}
