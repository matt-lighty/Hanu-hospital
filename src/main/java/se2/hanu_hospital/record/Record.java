package se2.hanu_hospital.record;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import se2.hanu_hospital.bill.Bill;
import se2.hanu_hospital.medical_procedure.MedicalProcedure;
import se2.hanu_hospital.patient.Patient;
import se2.hanu_hospital.prescription.Prescription;
import se2.hanu_hospital.staff.doctor.model.Doctor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(4) UNSIGNED ", precision = 4, updatable = false)
    private Long id;

    @Lob
    private String description = "This record does not have description";
    @Lob
    private String diagnosis = "This record does not have diagnosis yet";

    private boolean dischargePatient;

    @ManyToOne()
    @JoinColumn(name = "patient")
    @JsonIgnore
    private Patient patient;

    @ManyToOne()
    @JoinColumn(name = "doctor")
    @JsonIgnore
    private Doctor doctor;

    @OneToMany(mappedBy = "record")
    private Set<Prescription> prescriptionMedicine = new HashSet<>();

    @OneToMany(mappedBy = "record")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<MedicalProcedure> medicalProcedure = new HashSet<>();

    @OneToOne(mappedBy = "record")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Bill bill;

    public Record(Long id, String description, String diagnosis, Patient patient, Doctor doctor, Set<Prescription> prescriptionMedicine) {
        this.id = id;
        this.description = description;
        this.diagnosis =diagnosis;
        this.patient = patient;
        this.doctor = doctor;
        this.dischargePatient = false;
        this.prescriptionMedicine = prescriptionMedicine;
    }

    public Record() {
    }
    public Set<Prescription> getPrescriptionMedicine() {
        return prescriptionMedicine;
    }

    public void setPrescriptionMedicine(Set<Prescription> prescriptionMedicine) {
        this.prescriptionMedicine = prescriptionMedicine;
    }
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isDischargePatient() {
        return dischargePatient;
    }

    public void setDischargePatient(boolean dischargePatient) {
        this.dischargePatient = dischargePatient;
    }

    public Set<MedicalProcedure> getMedicalProcedure() {
        return medicalProcedure;
    }

    public void setMedicalProcedure(Set<MedicalProcedure> medicalProcedure) {
        this.medicalProcedure = medicalProcedure;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
