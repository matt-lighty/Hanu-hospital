package se2.hanu_hospital.staff.doctor.model;

import net.minidev.json.annotate.JsonIgnore;
import se2.hanu_hospital.record.Record;
import se2.hanu_hospital.staff.Staff;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor extends Staff {
    @Column(length = 255)
    private String speciality;
    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean available;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Record> records = new HashSet<>();

    public Doctor(String name, Long id, String phone, String email, LocalDate dob, Double salary, String speciality, boolean available) {
        super(name, id, phone, email, dob, salary);
        this.speciality = speciality;
        this.available = available;
    }

    public Doctor(){

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> record) {
        this.records = record;
    }
}
