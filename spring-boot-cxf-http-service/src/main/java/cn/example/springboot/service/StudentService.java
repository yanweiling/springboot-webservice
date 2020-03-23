package cn.example.springboot.service;



import cn.example.springboot.entity.Student;
import cn.example.springboot.entity.Students;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@WebService
public interface StudentService {
    @WebMethod
    public Student getStudent(@WebParam(name="id")Integer id);

    @WebMethod
    public Students getAllStudent(@WebParam(name = "ids")String ids);
}
