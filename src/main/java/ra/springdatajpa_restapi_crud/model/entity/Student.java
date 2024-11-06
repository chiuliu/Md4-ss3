package ra.springdatajpa_restapi_crud.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Integer studentId;

    @Column( columnDefinition = "nvarchar(50)", nullable = false, unique = true)
    private String studentName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthday")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

    @Column(name = "studentStatus")
    private Boolean studentStatus;
}
