package cn.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WebserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceClientApplication.class, args);
		log.info("spring-boot-webservice-client启动!");
	}

}
