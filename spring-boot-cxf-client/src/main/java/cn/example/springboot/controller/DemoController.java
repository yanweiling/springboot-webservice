package cn.example.springboot.controller;

import cn.example.springboot.webservice.AuthorDto;
import cn.example.springboot.webservice.AuthorPortType;
import org.apache.cxf.endpoint.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cxf")
public class DemoController {
    @Autowired
    Client client;

    @Autowired
    @Qualifier("cxfProxy")
    AuthorPortType authorPort;

    @GetMapping("/getauthorstring")
    public String getAuthorString(String authorName) {
        return authorPort.getAuthorString(authorName);
    }
    @GetMapping("/getauthor")
    public AuthorDto getAuthor(String authorName) {
        return authorPort.getAuthorByName(authorName);
    }

    @GetMapping("/getauthorlist")
    public List<AuthorDto> getAuthorList() {
        return authorPort.getAuthorList();
    }

    @GetMapping("/dynamic/{operation}")
    public Object getAuthorStringByDynamic(@PathVariable("operation")String operationName, String authorName) throws Exception {
        //这里就简单的判断了
        Object[] objects = null;
//        client.getEndpoint().getBinding().getBindingInfo().getOperations()
        if ("getAuthorList".equalsIgnoreCase(operationName)) {
            objects = client.invoke(operationName);
        } else if ("getAuthorString".equalsIgnoreCase(operationName)) {
            objects = client.invoke(operationName, authorName);
        } else if ("getAuthorByName".equalsIgnoreCase(operationName)) {
            objects = client.invoke(operationName, authorName);
        } else {
            throw new RuntimeException("无效的调用方法");
        }
        return objects != null && objects.length > 0 ? objects[0] : "返回异常";
    }

}
