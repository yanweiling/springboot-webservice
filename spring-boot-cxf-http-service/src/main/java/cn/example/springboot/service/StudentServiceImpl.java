//package cn.example.springboot.service;
//
//import cn.example.springboot.entity.Student;
//import cn.example.springboot.entity.Students;
//import org.springframework.stereotype.Component;
//
//import javax.jws.WebService;
//import java.util.ArrayList;
//
//@Component
//@WebService(endpointInterface = "cn.example.springboot.service.StudentService")
//public class StudentServiceImpl implements StudentService  {
//    @Override
//    public Student getStudent(Integer id) {
//        Student student=new Student();
//        student.setAddress("北京");
//        student.setAge(26);
//        student.setName("张三");
//        student.setSex('女');
//        return student;
//    }
//
//    @Override
//    public Students getAllStudent(String ids) {
//        Students students = new Students(new ArrayList<Student>());
//        for(int i=0;i<5;i++){
//            Student student=new Student();
//            student.setAddress("北京");
//            student.setAge(26);
//            student.setName("张三"+i);
//            student.setSex('女');
//            students.getStudents().add(student);
//        }
//        return students;
//    }
//}
