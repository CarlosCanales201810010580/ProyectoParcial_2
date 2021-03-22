package com.example.demo.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controladores"))
                //.paths(PathSelectors.any())
                .paths(regex("/ws.*"))
                .build()
                .apiInfo(getApiInfo());
    }
    
    private ApiInfo getApiInfo(){
        return new ApiInfo("Aplicaci�n Spring Boot"
                , "Contiene una Rest Api y una aplicaci�n web"
                , "0.0.0.1"
                , "http://uth.hn"
                , "Programaci�n Avanzada 2"
                , "Carlos Canales"
                , "UTH URL") ;
    }
}
