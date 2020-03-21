package cn.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WebserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceServerApplication.class, args);
		log.info("spring-boot-webservice-server启动!");
	}

}
