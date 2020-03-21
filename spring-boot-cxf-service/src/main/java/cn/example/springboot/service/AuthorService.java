package cn.example.springboot.service;

import cn.example.springboot.common.WsConst;
import cn.example.springboot.entity.AuthorDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = WsConst.NAMESPACE_URI,name = "authorPortType")
public interface AuthorService {

    /**
     * 根据名称获取作者信息
     * @return
     */
    @WebMethod(operationName = "getAuthorByName")
    AuthorDto getAuthor(@WebParam(name = "authorName") String name);
    /**
     * 获取作者列表信息
     */
    @WebMethod
    List<AuthorDto> getAuthorList();

    /**
     * 返回字符串测试
     */
    String getAuthorString(@WebParam(name = "authorName") String name);

}
