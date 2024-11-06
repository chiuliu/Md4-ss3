package ra.springdatajpa_restapi_crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.springdatajpa_restapi_crud.model.entity.Student;
import ra.springdatajpa_restapi_crud.model.sersive.impl.StudentServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080") //chap nhan nhung duong dan la bao nhieu
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer studentId ){
        return studentService.findById(studentId);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveOrUpdate(student);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        Student studentUpdate = studentService.findById(studentId);
        studentUpdate.setStudentName(student.getStudentName());
        studentUpdate.setAge(student.getAge());
        studentUpdate.setBirthday(student.getBirthday());
        studentUpdate.setStudentStatus(student.getStudentStatus());

        //Cap nhat
        return studentService.saveOrUpdate(studentUpdate);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        studentService.delete(studentId);
    }

    @GetMapping("/search")
    public List<Student> searchByNameOrId(@RequestParam("studentName") String studentName, @RequestParam("studentId") Integer studentId){
        return studentService.searchByName(studentName, studentId);
    }

    @GetMapping("/searchByAge")
    public List<Student> getStudentFromTo(@RequestParam("ageFrom") Integer ageFrom, @RequestParam("ageTo") Integer ageTo) {
        return studentService.getStudentsByAgeBetween(ageFrom, ageTo);
    }
}
