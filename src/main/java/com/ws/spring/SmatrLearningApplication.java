package com.ws.spring;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@Log4j2
public class SmatrLearningApplication {

	public static void main(String[] args) {
		log.debug("application Started : {}" , new Date());
		SpringApplication.run(SmatrLearningApplication.class, args);
	}
	
	/*
	 * @Bean public MultipartConfigElement multipartConfigElement() {
	 * MultipartConfigFactory factory = new MultipartConfigFactory();
	 * factory.setMaxFileSize(DataSize.ofMegabytes(10));
	 * factory.setMaxRequestSize(DataSize.ofMegabytes(10)); return
	 * factory.createMultipartConfig(); }
	 */
	
	/*
	 * @Bean public CommonsMultipartResolver multipartResolver(){
	 * CommonsMultipartResolver commonsMultipartResolver = new
	 * CommonsMultipartResolver();
	 * commonsMultipartResolver.setDefaultEncoding("utf-8");
	 * commonsMultipartResolver.setMaxUploadSize(50000000);
	 * commonsMultipartResolver.setMaxUploadSizePerFile(50000000); return
	 * commonsMultipartResolver; }
	 */
	/*
	 * @Bean public MultipartResolver multipartResolver() { return new
	 * StandardServletMultipartResolver(); }
	 */

}
