package cn.example.springboot.config;

import cn.example.springboot.webservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Arrays;
import java.util.Date;

/**
 * 创建endpoint 类似于创建controller了。
 * @author oKong
 *方法声明上的 @PayloadRoot标注中的namespace和localPart分别就是wsdl中的targetNamespace和soap方法名称。
 * @ResponsePayload和 @RequestPayload 这两个标注的用法，以及它们对应的数据类型就是此前通过maven插件对wsdl定义生成的java类。
 */
@Endpoint
public class AuthorEndpoint {

    @PayloadRoot(namespace = WsConst.NAMESPACE_URI,localPart = "authorRequest")
    @ResponsePayload
    public AuthorResponse getAuthor(@RequestPayload AuthorRequest authorReq){
        AuthorResponse resp = new AuthorResponse();
        Author author = new Author();
        author.setBirthday("1990-01-23");
        author.setName("姓名：" + authorReq.getName());
        author.setSex(Sex.FEMALE);
        author.getHobby().addAll(Arrays.asList("电影","旅游"));
        author.setDescription("描述：一枚趔趄的猿。现在时间：" + new Date().getTime());
        resp.setAuthor(author);
        return resp;
    }
    @PayloadRoot(namespace = WsConst.NAMESPACE_URI, localPart = "authorListRequest")
    @ResponsePayload
    public AuthorListResponse getAuthorList(@RequestPayload AuthorListRequest request){
        AuthorListResponse resp = new AuthorListResponse();
        Author author = new Author();
        author.setBirthday("1990-01-23");
        author.setName("姓名：oKong");
        author.setSex(Sex.FEMALE);
        author.getHobby().addAll(Arrays.asList("电影","旅游"));
        author.setDescription("描述：一枚趔趄的猿。现在时间：" + new Date().getTime());
        resp.getAuthor().add(author);
        resp.getAuthor().add(author);
        return resp;
    }
}
