package cn.example.springboot;

import cn.example.springboot.entity.Student;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.core.Response;

@SpringBootTest
public class Test {
   @org.junit.Test
    public void test(){
        WebClient client = WebClient.create("http://localhost:8082");
        client.path("/cxf/webservice/studentapi/getjson").accept("application/json").type("application/json");
        String response=client.get(String.class);
       System.out.println(response);
    }
}
