package biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public void printLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("         시작 로그 05");
		
		Object object = pjp.proceed();
		
		
		System.out.println("         종료 로그 06");
	}
}
