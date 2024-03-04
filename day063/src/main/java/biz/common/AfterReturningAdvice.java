package biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.bPointcut()", returning="returnObj")
	public void printLog(JoinPoint jp, Object returnObj) {
		System.out.println("         비즈니스 메서드 수행 후 로그 03");
	}
	// 바인드 변수
	// 동적바인딩 => 오버로딩
	// 바인딩이란 	>> 메서드를 호출했을 때, 현재 메모리에 존재하는 객체를 실제로 수행하는 것
	//			>> 다형성을 구현한 상황에서 사용가능
}
