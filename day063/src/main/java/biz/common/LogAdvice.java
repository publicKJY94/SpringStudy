package biz.common;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service// advice 생성
@Aspect	// 위빙 처리
public class LogAdvice {
	// 어떤 포인트 컷과 어떤방식으로 연결할 것인가
	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("         로그 01"+methodName);
		
	}
}
