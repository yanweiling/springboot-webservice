package cn.example.springboot.resource;

import cn.example.springboot.entity.Student;
import cn.example.springboot.entity.Students;
import cn.example.springboot.service.StudentService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;


@Path("/")
public class StudentInterfaceImpl implements StudentInterface {
    @Autowired
    private StudentService studentService;

    // 获取json
    @Override
    @GET
    @Path("/getjson")
    @Produces({ MediaType.APPLICATION_JSON })
    public Student getStudent() {
        Student student=new Student();
        student.setAddress("北京");
        student.setAge(26);
        student.setName("张三");
        student.setSex('女');
        return student;
    }

    // 获取xml
    @GET
    @Path("/getxml")
    @Produces({ MediaType.APPLICATION_XML })
    public Student getStudent2() {
        Student student=new Student();
        student.setAddress("北京");
        student.setAge(26);
        student.setName("张三");
        student.setSex('女');
        return student;
    }

    @Override
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/getall")
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
