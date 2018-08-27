package com.Lee.member.aoptest;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class aopTest {
	//포인트컷(pointcut)+어드바이스(advice)를 합쳐서 에스팩트(aspect)라고함.
	/* ponntcut은 호출되는 위치 지정과 관련됨
	 * advice는 해당 위치에서 어떤 기능을 수행할 것인지를 정의하는 것.
	 */
	
	//포인트컷 정의
	/*
	 * ("execution(* com.Lee.member..*Service.*(..))")
	 * 1. * : 모든 리턴타입
	 * 2. com.Lee.member 적용할 패키지 지정
	 * 3. com.Lee.member..*Service : com.Lee.member 패키이제 소속되어 있는 모든 패키지 중에서 클래스 이름이 Service로 끝나는
	 *    모든 클래스를 지정함.
	 * 4. *(..) : 앞의 *은 모든 메소드를 의미하며 예를 들어 get* 형식으로 쓰면 get으로 시작하는 모든 메소드
	 * 	   (..)은 모든 매개변수를 포함한다는 의미(개수, 타입 상관없음)
	 */
	@Pointcut("execution(* com.Lee.member..*Service.*(..))")
	public void allPointcut() {
		
	}
	//아래의 두 메소드는 어드바이스 정의
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("=====AOP TEST Before Annotation=========");
	}
	
	@AfterReturning("allPointcut()")
	public void printLogAfter() {
		System.out.println("=====AOP TEST After Annotation=========");
	}
	
}
