package cn.example.springboot.resource;

import cn.example.springboot.entity.Student;
import cn.example.springboot.entity.Students;

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
