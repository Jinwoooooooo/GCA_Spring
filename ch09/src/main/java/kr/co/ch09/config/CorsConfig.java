package kr.co.ch09.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

         /*
            CORS 설정
             - Cross-Origin-Resource-Sharing
             - 웹 애플리케이션에서 다른 도메인의 리소스에 접근하는 HTTP 정책
             - HTTP 통신은 기본적으로 보안상의 이유로 다른 도메인의 리소스 접근을 차단
             - API로 서비스하기위해 CORS 정책을 허용
        */
        registry
                .addMapping("/**")      // 모든 엔드포인트에 대해 CORS를 활성화합니다.
                .allowedOriginPatterns("http://127.0.0.1:5501", "http://localhost:5501") // 해당 도메인 origin의 요청 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드를 지정, OPTIONS은 pre-flight 요청을 위한 Method
                .allowedHeaders("*")            // 모든 헤더를 허용합니다. 필요에 따라 변경할 수 있습니다.
                .allowCredentials(true)         // 자격 증명 허용 여부를 설정합니다.
                .maxAge(3600);                  // pre-flight 요청의 유효 기간을 설정합니다.
    }
}