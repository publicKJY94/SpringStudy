package biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@AfterThrowing(pointcut="PointcutCommon.aPointcut()", throwing ="exceptionObj")
	public void printLog(JoinPoint jp, Object exceptionObj) {
		System.out.println("         예외상황 발생 로그 04");
	}
}
