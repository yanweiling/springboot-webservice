package cn.example.springboot.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import cn.example.springboot.webservice.AuthorListRequest;
import cn.example.springboot.webservice.AuthorListResponse;
import cn.example.springboot.webservice.AuthorRequest;
import cn.example.springboot.webservice.AuthorResponse;

import java.util.UUID;

/**
 * 编写客户端 继承WebServiceGatewaySupport 类 方便调用
 */
public class WsAuthorClient extends WebServiceGatewaySupport {
    /**
     *  获取作者信息
     *  @author oKong
     */
    public AuthorResponse getAuthor(String name) {
        AuthorRequest req = new AuthorRequest();
        req.setName(name);
        //使用 marshalSendAndReceive 进行调用
        return (AuthorResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    /**
     *  获取作者列表信息
     *  @author oKong
     */
    public AuthorListResponse getAuthorList(){
        AuthorListRequest request = new AuthorListRequest();
        request.setNonce(UUID.randomUUID().toString());
        return (AuthorListResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
