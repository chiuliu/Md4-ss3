package ra.springdatajpa_restapi_crud.model.sersive.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.springdatajpa_restapi_crud.model.entity.Student;
import ra.springdatajpa_restapi_crud.model.repository.IStudentRepository;
import ra.springdatajpa_restapi_crud.model.sersive.IStudentService;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(rollbackFor = SQLException.class)
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchByName(String search, Integer studentId) {
        return studentRepository.findByStudentNameOrStudentId(search, studentId);
    }

    @Override
    public List<Student> getStudentsByAgeBetween(Integer ageFrom, Integer ageTo) {
        return studentRepository.getStudentsByAgeBetween(ageFrom, ageTo);
    }
}
