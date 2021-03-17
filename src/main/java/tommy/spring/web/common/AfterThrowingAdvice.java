package tommy.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	@AfterThrowing(pointcut = "PointcutCommon.allPointcut()", throwing = "e")
	public void exceptionLog(JoinPoint joinpoint, Exception e) {
		String method = joinpoint.getSignature().getName();
		System.out.println("[예외처리] : " + method + "() 메서드 수행 중 발생도니 예외 메시지 : " + e.getMessage());
	}
}
