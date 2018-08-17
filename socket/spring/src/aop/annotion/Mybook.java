package aop.annotion;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
//使用注解方式实现aop
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Mybook {
	
	//around增强处理
	@Around(value="execution(* aop.annotion.Book.*(..))")
	public Object processTx(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around增强，执行目标方法之前，模拟事务开始");
		//获取目标方法的参数
		Object[] args=jp.getArgs();
		if (args!=null &&args.length>0&&args[0].getClass()==String.class) {
			args[0]="增加的前缀"+args[0];
			
		}
		//执行目标方法
		Object proceed = jp.proceed(args);
		
		System.out.println("增强结束");
		if (proceed==null) {
			return "无返回值";
		}
		return "目标方法的返回类型为"+proceed.getClass(); 
	}
	//before增强处理
	@Before(value="execution(* aop.annotion.Book.*(..))")
	public void authority(JoinPoint jp) {
		System.out.println("before增强处理，模拟执行权限检查");
		System.out.println("目标方法为" +jp.getSignature().getName());
		System.out.println("目标方法参数为"+Arrays.toString(jp.getArgs()));
		System.out.println("增强处理后的目标对象"+jp.getTarget());
	}
}
