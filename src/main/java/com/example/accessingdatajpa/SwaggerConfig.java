package com.example.accessingdatajpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    //    https://blog2.deliwind.com/20201127/java-swagger-ui-3-0-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0/

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) // open api spec 3.0
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}


//@Configuration
////@EnableSwagger2
//public class SwaggerConfig {
//// swagger 2.9.2 버전 설정
////    implementation group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'
////    implementation group: 'io.springfox', name: 'springfox-swagger2', version: '2.9.2'
////
//    @Bean
//    public Docket restAPI() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hobbybee"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("hobbybee Spring Boot REST API")
//                .version("1.0.0")
//                .description("취미 생활 커뮤니티 hobbybee의 swagger api 입니다.")
//                .build();
//    }
//
///*
//apis : 대상 패키지 설정
//paths : 어떤 식으로 시작하는 api 를 보여줄것인지?
//any는 그냥 전부다. 만약, member/ 라고 설정하면 member로 시작하는 api 만 볼 수 있게 설정 가능하다.
//*/
//
//}

