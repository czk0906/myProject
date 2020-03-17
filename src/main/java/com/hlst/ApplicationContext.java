package com.hlst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
/**
 * springboot启动类
 * @author Czk
 *
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.hlst.*.mapper")
@EnableAutoConfiguration
public class ApplicationContext {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationContext.class, args);
	}
}
