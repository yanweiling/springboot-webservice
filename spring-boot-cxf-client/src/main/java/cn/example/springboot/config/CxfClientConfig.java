package cn.example.springboot.config;

import cn.example.springboot.common.WsConst;
import cn.example.springboot.webservice.AuthorPortType;
import cn.example.springboot.webservice.AuthorService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfClientConfig {
    /**
     * 以接口代理方式进行调用AuthorPortType接口
     */
    @Bean("cxfProxy")
    public AuthorPortType createAuthorPortTypeProxy(){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AuthorPortType.class);
        jaxWsProxyFactoryBean.setAddress(WsConst.SERVER_ADDRESS);
        return (AuthorPortType) jaxWsProxyFactoryBean.create();
    }
    /**
     * 采用动态工厂方式，不需要指定动态接口
     */
    @Bean
    public Client createDynamicClient(){
        JaxWsDynamicClientFactory dcf=JaxWsDynamicClientFactory.newInstance();
        Client client=dcf.createClient(WsConst.SERVER_ADDRESS);
        return client;
    }

    /**
     * 除了使用JaxWsProxyFactoryBean和JaxWsDynamicClientFactory调用外，
     * 还可以直接使用自动生成的AuthorService类直接调用的，此类继承至javax.xml.ws.Service。
       直接调用
     */
    @Bean("jdkProxy")
    public AuthorPortType createJdkService(){
        AuthorService authorService=new AuthorService();
        return authorService.getAuthorPortName();
    }

}
