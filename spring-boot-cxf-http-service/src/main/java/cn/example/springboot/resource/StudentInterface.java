package cn.example.springboot.resource;

import cn.example.springboot.entity.Student;
import cn.example.springboot.entity.Students;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
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
