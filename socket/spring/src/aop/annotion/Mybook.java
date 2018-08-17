package aop.annotion;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
//ʹ��ע�ⷽʽʵ��aop
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Mybook {
	
	//around��ǿ����
	@Around(value="execution(* aop.annotion.Book.*(..))")
	public Object processTx(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around��ǿ��ִ��Ŀ�귽��֮ǰ��ģ������ʼ");
		//��ȡĿ�귽���Ĳ���
		Object[] args=jp.getArgs();
		if (args!=null &&args.length>0&&args[0].getClass()==String.class) {
			args[0]="���ӵ�ǰ׺"+args[0];
			
		}
		//ִ��Ŀ�귽��
		Object proceed = jp.proceed(args);
		
		System.out.println("��ǿ����");
		if (proceed==null) {
			return "�޷���ֵ";
		}
		return "Ŀ�귽���ķ�������Ϊ"+proceed.getClass(); 
	}
	//before��ǿ����
	@Before(value="execution(* aop.annotion.Book.*(..))")
	public void authority(JoinPoint jp) {
		System.out.println("before��ǿ����ģ��ִ��Ȩ�޼��");
		System.out.println("Ŀ�귽��Ϊ" +jp.getSignature().getName());
		System.out.println("Ŀ�귽������Ϊ"+Arrays.toString(jp.getArgs()));
		System.out.println("��ǿ������Ŀ�����"+jp.getTarget());
	}
}
