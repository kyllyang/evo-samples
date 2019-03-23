package com.github.framework.evo.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * User: Kyll
 * Date: 2018-02-26 20:53
 */
@MapperScan(basePackages = "com.github.framework.evo.sample.dao")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EvoSampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(EvoSampleApplication.class, args);
	}
}
