package cn.example.springboot.resource;

import cn.example.springboot.entity.Student;
import cn.example.springboot.entity.Students;
import org.springframework.web.bind.annotation.GetMapping;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public interface StudentInterface {
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/getone")
    public Student getStudent();

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/getmany")
    public Students getAllStudent();
}
