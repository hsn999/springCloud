package com.springcloud.mvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.springcloud.mvc.app.mapper")
@EnableSwagger2
public class WvcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WvcApplication.class, args);
	}

}
