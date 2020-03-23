项目发布了restful接口  接口所在包resource  相关的配置文件cxf-config.xml----会生成WADL文件

项目发布了soap的接口  接口所在包service ---会生成wsdl文件--可以由wsdl文件自动生成java实体类

项目启动后，访问
http://localhost:8082/cxf  可以看到发布的wsdl和wadl文件

例子：
请求restfule接口  http://localhost:8082/cxf/webservice/studentapi/getjson




