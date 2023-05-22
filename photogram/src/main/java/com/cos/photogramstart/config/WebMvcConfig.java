package com.cos.photogramstart.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{ //web 설정파일

	@Value("${file.path}")
	private String UploadFolder;
	
	@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			WebMvcConfigurer.super.addResourceHandlers(registry);
			
			//path: C:/IT_Peng/Study_STS2305/photogram/src/main/upload
			registry
			.addResourceHandler("/upload/**") //jsp 페이지에서 /upload/** 이런 주소 패턴이 나오면 발동
			.addResourceLocations("file:///"+UploadFolder)
			.setCachePeriod(60*10*6) //초, 캐시유지시간
			.resourceChain(true)
			.addResolver(new PathResourceResolver());

		}
}
