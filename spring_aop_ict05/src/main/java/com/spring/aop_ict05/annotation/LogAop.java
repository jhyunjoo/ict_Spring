package com.spring.aop_ict05.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 횡단관심 클래스(공통 클래스) => 핵심관심 출력메서드의 경과시간에 대한 로그 출력 클래스
@Aspect
public class LogAop {
	
	@Pointcut("execution(* com.spring.aop_ict05.annotation.*.*(..))")
	public void allPointCut() {}
	
	@Around("allPointCut()")
	public void loggerAop(ProceedingJoinPoint joinPoint) {
		
		// 핵심클래스, 비즈니스 메서드 정보 가져오기(Member 클래스의 getMemberInfo() 가져오기)
		String signatureStr = joinPoint.getSignature().toLongString();
		System.out.println(signatureStr + " is start!!");
		Long start = System.currentTimeMillis();	// 비즈니스 메서드 시작 시간

		try {
			joinPoint.proceed();	// 핵심관리 메서드 호출
		} catch(Throwable e) {
			e.printStackTrace();
		} finally {
			Long end = System.currentTimeMillis();	// 비즈니스 메서드 종료 시간
			System.out.println(signatureStr + "is end!!");
			
			System.out.println(signatureStr + "경과시간 : " + (end - start));
		}
		
	}
}
