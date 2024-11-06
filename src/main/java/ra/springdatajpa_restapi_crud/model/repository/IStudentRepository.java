package ra.springdatajpa_restapi_crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.springdatajpa_restapi_crud.model.entity.Student;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
     List<Student> findByStudentNameOrStudentId(String search, Integer studentId);
     List<Student> getStudentsByAgeBetween(Integer ageFrom, Integer ageTo);

}
