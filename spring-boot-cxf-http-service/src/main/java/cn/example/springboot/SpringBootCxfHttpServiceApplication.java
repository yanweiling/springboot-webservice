package cn.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource(locations = {"classpath:cxf-config.xml"})
public class SpringBootCxfHttpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCxfHttpServiceApplication.class, args);
	}

}
