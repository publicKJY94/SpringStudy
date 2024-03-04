package biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice2 {
	@Before("PointcutCommon.bPointcut()")
	public void printLog() {
		System.out.println("         버전업!된 로그 02");
	}
}
