package org.example;

import org.example.config.AppConfig;
import org.example.sub1.Greeting;
import org.example.sub1.Hello;
import org.example.sub1.Welcome;
import org.example.sub2.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 날짜 : 2025/03/10
 * 이름 : 정진우
 * 내용 : ch02. Spring IoC/DI 실습하기
 *
 * @Configuration
 *  - 애플리케이션을 구성하는 Bean(객체)을 스프링 컨테이너에 등록하기 위한 설정 클래스
 *
 * @Bean
 *  - 컨테이너에 등록하기 위한 Bean 설정 어노테이션
 *  - 사용자 정의 클래스 등록 어노테이션
 *
 * @ComponentScan
 *  - basePackage로 시작하는 패키지내의 Bean을 스캔해서 컨테이너에 등록시키는 어노테이션
 *  - 스캔 대상 컴포넌트는 @Component(@Service, @Repository) 어노테이션 선언해야 됨
 *  
 * @Autowired
 *  - 컨테이너에 등록되어 있는 Bean을 주입하는 어노테이션
 *  - 이름 또는 클래스 타입으로 매칭된 Bean을 주입ㅠ
 */
public class App {
    public static void main( String[] args ) {

        //------------------------------------------
        //기존 객체 생성 방식
        Hello hello = new Hello();
        Welcome welcome = new Welcome();
        Greeting greeting = new Greeting();

        hello.show();
        welcome.show();
        greeting.show();

        //------------------------------------------
        //스프링 컨테이너 객체 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Hello helloBean = context.getBean(Hello.class);
        helloBean.show();

        Welcome welcomeBean = (Welcome) context.getBean("welcome");
        welcomeBean.show();

        Greeting greetingBean = (Greeting) context.getBean("ggg");
        greetingBean.show();
        //------------------------------------------
        //IoC/DI 기법을 이용한 객체  실습
        Computer computer = (Computer) context.getBean("com");
        computer.show();
    }
}
