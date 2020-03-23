package cn.example.springboot.controller;

import cn.example.springboot.entity.Student;
import cn.example.springboot.entity.Students;
import cn.example.springboot.service.StudentService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    @Autowired
    StudentService studentService;
    @GetMapping("/get")
    public String getStudent(){
        Student student=studentService.getStudent(1);
        return JSONObject.toJSONString(student);
    }

    @GetMapping("/getAll")
    public String getAll(){
        Students students = studentService.getAllStudent(null);
        Object json = JSONObject.toJSON(students);
        return json.toString();
    }



}
