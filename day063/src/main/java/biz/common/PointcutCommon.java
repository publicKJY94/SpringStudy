package biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	// 포인트 컷 등록
	@Pointcut("execution(* biz..*Impl.*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* biz..*Impl.select*(..))")
	public void bPointcut() {}
}
