package com.example.myconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
@RefreshScope  // 这个注解声明了刷新配置的范围，如果使用config配置类的话，就声明到配置类上即可
public class MyConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyConfigClientApplication.class, args);
	}

	@Value("${hello}")
	private String hello;

	@RequestMapping("hello")
	public String hello() {
		return hello;
	}

}
