package cn.example.springboot.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Students")
public class Students {
    private List<Student> students;

    public Students(List<Student> students) {
        super();
        this.students = students;
    }

    @XmlElement(name = "Student")
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
