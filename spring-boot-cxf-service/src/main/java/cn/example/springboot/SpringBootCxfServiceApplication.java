package cn.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootCxfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCxfServiceApplication.class, args);
		log.info("spirng-boot-cxf-service-启动!");
	}

}
