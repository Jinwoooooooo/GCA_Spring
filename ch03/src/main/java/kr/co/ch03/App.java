package kr.co.ch03;

import kr.co.ch03.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 날짜 : 2025/03/10
 * 이름 : 정진우
 * 내용 : ch03. Spring AOP 실습
 *
 *  라이브러리
 *   - spring-aspects 의존성 추가
 *
 *  주요용어
 *   1) 조인포인트(JoinPoint)
 *    - 실행하는 모든 핵심관심 메서드
 *
 *   2) 포인트컷(PointCut)
 *    - 조인포인트 가운데 실행(AOP가 설정)되는 핵심관심 메서드
 *
 *   3) 어드바이스(Advice)
 *    - 횡단관심에 해당하는 공통의 부가기능 메서드
 *
 *   4) 애스펙트(Aspect)
 *    - 포인트컷과 어드바이스의 결합된 모듈형태
 *
 *   5) 위빙(Weaving)
 *    - 포인트컷(핵심관심)이 실행될 때 어드바이스가 포인트컷에 결합되는 과정
 *
 *  포인트컷 표현식
 *   execution(리턴타입 패키지명.클래스명.메서드명(매개변수))
 *
 *   1) 리턴타입
 *    - *       : 모든 리턴타입 허용
 *    - void    : 리턴타입이 void인 메서드
 *    - !void   : 리턴타입이 void가 아닌 메서드
 *
 *   2) 패키지명
 *    - kr.co.ch03          : 해당 패키지 대상
 *    - kr.co.ch03..        : kr.co.ch03로 시작하는 모든 패키지 대상
 *    - kr.co.ch03..service : kr.co.ch03로 시작해서 마지막 패키지명이 service로 끝나는 패키지 대상
 *
 *   3) 클래스명
 *    - BasicService : 해당 클래스 대상
 *    - *Service     : 클래스명이 Service로 끝나는 클래스 대상
 *
 *   4) 메서드명
 *    - *(..)  : 매개변수가 제한이 없는 모든 메서드
 *    - *(*)   : 매개변수를 1개 갖는 모든 메서드
 *    - *(*,*) : 매개변수를 2개 갖는 모든 메서드
 *    - get*() : 매개변수가 없고 메서드 이름이 get으로 시작하는 메서드
 */
public class App {
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = (MyService) context.getBean("myService");

        myService.insert();
        myService.select(null);
        myService.update();
        myService.delete();
    }
}
