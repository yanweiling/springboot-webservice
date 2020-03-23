package cn.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootCxfHttpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCxfHttpClientApplication.class, args);
	}

}
