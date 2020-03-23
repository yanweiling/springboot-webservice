package cn.example.springboot.resource;

import cn.example.springboot.entity.Student;
import cn.example.springboot.entity.Students;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

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
