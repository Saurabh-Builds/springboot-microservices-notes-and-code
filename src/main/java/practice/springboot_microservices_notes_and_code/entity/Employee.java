package practice.springboot_microservices_notes_and_code.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Id
    private Integer empId;
    private String empName;
    private Double empSalary;
    private String empGender;
    private String empDept;
}
