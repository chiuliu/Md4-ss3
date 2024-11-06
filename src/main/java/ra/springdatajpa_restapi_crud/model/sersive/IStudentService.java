package ra.springdatajpa_restapi_crud.model.sersive;


import ra.springdatajpa_restapi_crud.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Integer studentId);
    Student saveOrUpdate(Student student);
    void delete(Integer studentId);
    List<Student> searchByName(String search, Integer studentId);
    List<Student> getStudentsByAgeBetween(Integer ageFrom, Integer ageTo);

}
