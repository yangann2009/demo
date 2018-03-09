package com.mjmh.demo.controller;

import com.mjmh.demo.entity.Student;
import com.mjmh.demo.service.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/getall")
    public List<Student> getAll() {
        logger.error("logback /student/getall");
        logger.info("logback 访问student");
        return studentRepository.findAll();
    }

    /**
     * 添加一个student,使用postMapping接收post请求
     * @return
     */
    @PostMapping("/addStudent")
    public Student addStudent(@RequestParam("name") String name, @RequestParam("age") Integer age){
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    /**
     * 根据ID获取student，接收ID参数
     * @param id
     * @return
     */
    @GetMapping("/getStudent/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Integer id){
        return studentRepository.findById(id);
    }

    /**
     * 根据id更新student
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Integer age){
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    /**
     * 根据id删除student
     * @param id
     */
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentRepository.deleteById(id);
    }

    /**
     * 根据name获取student
     * @param name
     * @return
     */
    @GetMapping("/getStudentByName/{id}")
    public List<Student> getStudentById(@PathVariable("name") String name){
        return studentRepository.findByName(name);
    }

}
