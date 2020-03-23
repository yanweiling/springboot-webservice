# springboot-webservice
https://blog.lqdev.cn/2018/11/12/springboot/chapter-thirty-four/ --笔记
# SpringBoot集成cxf框架实现webservice
## 实现Restful接口
**步骤1 引入包**

```
 <properties>
		<java.version>1.8</java.version>
		<cxf.version>3.1.11</cxf.version>
	</properties>
<!-- 提供JacksonJsonProvider-->
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-jersey</artifactId>
</dependency>
<dependency>
   <groupId>org.apache.cxf</groupId>
   <artifactId>cxf-spring-boot-starter-jaxrs</artifactId>
   <version>${cxf.version}</version>
</dependency>
<dependency>
   <groupId>org.apache.cxf</groupId>
   <artifactId>cxf-rt-rs-service-description</artifactId>
   <version>${cxf.version}</version>
</dependency>
<dependency>
   <groupId>org.apache.cxf</groupId>
   <artifactId>cxf-rt-frontend-jaxws</artifactId>
   <version>${cxf.version}</version>
</dependency>
<dependency>
   <groupId>org.apache.cxf</groupId>
   <artifactId>cxf-rt-transports-http</artifactId>
   <version>${cxf.version}</version>
</dependency>
<dependency>
   <groupId>org.apache.cxf</groupId>
   <artifactId>cxf-rt-transports-http-jetty</artifactId>
   <version>${cxf.version}</version>
</dependency>
```
**步骤2 新增实体类**
```java

@XmlRootElement(name = "Student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private char sex;
    private String address;
    private Integer age;
	//get set 忽略
}
```
```java
@XmlRootElement(name = "Students")
public class Students {
    @XmlElement(name = "Student")
    private List<Student> students;

    public Students(List<Student> students) {
        super();
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Students() {
        super();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
```
**步骤3 创建CXF配置类**
```java
@Configuration
public class CxfConfig {
    @Bean
    public ServletRegistrationBean newServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/cxf/*");
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
// 构造一个json转化bean，用于将student转化为json，因为后面需要用这个bean配置json转化，所以给他取个名
    @Bean("jsonProvider")
    public JacksonJsonProvider getJacksonJsonProvider(){
        return new JacksonJsonProvider();
    }

}

```
`
说明：cxf/* 请求将被cxf拦截`

**步骤4 新增接口**
在classpath下新建配置文件cxf-config.xml
```java
@Consumes({MediaType.APPLICATION_JSON})//支持json格式的请求
@Produces({MediaType.APPLICATION_JSON})//返回json
@Path("/studentapi")
public interface StudentInterface {
    @GET
    @Path("/getjson")
    public Student getStudentJson();
    @GET
    @Path("/getxml")
    public Student getStudentXml();

    @GET
    @Path("/getall")
    public Students getAllStudent();
}
```
```java
public class StudentInterfaceImpl implements StudentInterface {
    // 获取json
    @Override
    public Student getStudentJson() {
        Student student=new Student();
        student.setAddress("北京");
        student.setAge(26);
        student.setName("张三");
        student.setSex('女');
        return student;
    }
    // 获取xml
   @Override
    public Student getStudentXml() {
        Student student=new Student();
        student.setAddress("北京");
        student.setAge(26);
        student.setName("张三");
        student.setSex('女');
        return student;
    }
    @Override
    public Students getAllStudent() {
        Students students = new Students(new ArrayList<Student>());
        for(int i=0;i<5;i++){
            Student student=new Student();
            student.setAddress("北京");
            student.setAge(26);
            student.setName("张三"+i);
            student.setSex('女');
            students.getStudents().add(student);
        }
        return students;
    }
}

```
**步骤5 发布接口**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:jaxrs="http://cxf.apache.org/jaxrs"
       xmlns:context="http://www.springframework.org/schema/context" xsi:schemaLocation="
       http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
       http://cxf.apache.org/jaxrs http://cxf.apache.org/schemas/jaxrs.xsd
       http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 将Bean托管给Spring -->
    <bean id="studentService" class="cn.example.springboot.resource.StudentInterfaceImpl">
    </bean>
    <!-- 配置需要暴露的BeanService -->
    <jaxrs:server id="restContainer" address="/webservice"> <!-- 暴露restful api 类似于前文提到的webService【暴露soap】 -->
        <jaxrs:serviceBeans>
            <!-- 相当于打包发布服务 -->
            <ref bean="studentService" />
        </jaxrs:serviceBeans>
        <!-- 提供一个json转化，没有这个不能自动返回json jsonProvider就是前面@Bean生成的在CxfConfig -->
        <jaxrs:providers>
            <ref bean="jsonProvider" />
        </jaxrs:providers>
    </jaxrs:server>
</beans>
```
**步骤6 编写启动类**
```java
//因为没有涉及数据库连接，所以需要关闭自动配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource(locations = {"classpath:cxf-config.xml"})
public class SpringBootCxfHttpServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCxfHttpServiceApplication.class, args);
	}
}
```
**步骤7 查看wadl文件**
`webservice如果是soap协议的，则发布后，会生成wsdl文件，如果是restfule形式的，发布后，会生成wadl文件`
**请求http://localhost:8082/cxf**

![image-20200323184942442](C:\Users\yanwlb\AppData\Roaming\Typora\typora-user-images\image-20200323184942442.png)

**点击http://localhost:8082/cxf/webservice?_wadl**

![image-20200323185504025](C:\Users\yanwlb\AppData\Roaming\Typora\typora-user-images\image-20200323185504025.png)

**请求：http://localhost:8082/cxf/webservice/studentapi/getjson**

**请求：http://localhost:8082/cxf/webservice/studentapi/getall**

返回报文

```
{"id":null,"name":"张三","sex":"女","address":"北京","age":26}
```

```
	"students": [{
		"id": null,
		"name": "张三0",
		"sex": "女",
		"address": "北京",
		"age": 26
	},.....
}
```

**步骤8  新建客户端项目，引入包**

```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter</artifactId>
</dependency>
<dependency>
   <groupId>org.apache.cxf</groupId>
   <artifactId>cxf-spring-boot-starter-jaxrs</artifactId>
   <version>${cxf.version}</version>
</dependency>
<dependency>
   <groupId>com.alibaba</groupId>
   <artifactId>fastjson</artifactId>
   <version>1.2.7</version>
</dependency>
```

**步骤9  编写测试类**

```java
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
```

