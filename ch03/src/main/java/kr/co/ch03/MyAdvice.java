package kr.co.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

    @Pointcut("execution(void kr.co.ch03.MyService.insert())")
    public void insertPointCut() {}

    // * = 와일드카드
    // (..) = 매개변수 제한 없음.
    @Pointcut("execution(void kr.co.ch03.MyService.select*(..))")
    public void selectPointCut() {}

    @Before("insertPointCut() || selectPointCut()")
    public void beforeAdvice() {
        System.out.println("부가기능 - BeforeAdvice()");
    }

    @After("insertPointCut() || selectPointCut()")
    public void afterAdvice() {
        System.out.println("부가기능 - AfterAdvice()");
    }

    @AfterReturning("insertPointCut()")
    public void afterReturnAdvice() {
        System.out.println("부가기능 - AfterReturnAdvice()");
    }

    @Around("insertPointCut()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("부가기능 - AroundAdvice(1)");
        pjp.proceed(); //핵심기능 실행
        System.out.println("부가기능 - AroundAdvice(2)");
    }

    @AfterThrowing("selectPointCut()")
    public void afterThrowAdvice() {
        System.out.println("부가기능 - AfterThrowAdvice()");
    }
}
