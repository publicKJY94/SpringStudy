package com.spring.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
// 비즈니스 메서드(model, service단에서만 사용가능하다)
@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* com.spring.biz..*Impl.select*(..))")
	public void bPointcut() {}
}
