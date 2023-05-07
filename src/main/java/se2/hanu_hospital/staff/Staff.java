package se2.hanu_hospital.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import se2.hanu_hospital.account.model.User;
import se2.hanu_hospital.department.Department;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Staff {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String phone;
    private String email;
    private LocalDate dob;
    private Double salary;
    @ManyToOne
    @JoinColumn(name = "department")
    @JsonIgnore
    private Department department;


    @OneToOne()
    private User user;

    public Staff() {
    }

    public Staff(String name, Long id, String phone, String email, LocalDate dob, Double salary, Department department) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.salary = salary;
        this.department = department;
    }

    public Staff(String name, Long id, String phone, String email, LocalDate dob, Double salary) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.salary = salary;
    }

    public Staff(String name, String phone, String email, LocalDate dob, Double salary) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
