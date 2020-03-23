package cn.example.springboot;

import cn.example.springboot.entity.Student;
import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CxfTest {
    @Autowired
    RestTemplate restTemplate;
    @Test
    public void test(){
//        Response student=WebClient.create("http://localhost:8082/cxf/webservice/studentapi/getjson")
//                .type(MediaType.APPLICATION_JSON).get();
        Student student=restTemplate.getForObject("http://localhost:8082/cxf/webservice/studentapi/getjson",Student.class);

        System.out.println(JSONObject.toJSONString(student));
    }
}
