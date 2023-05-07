package se2.hanu_hospital.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = {"/api/prescription"})
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(prescriptionService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            prescriptionService.delete(id);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody Prescription prescription, @RequestParam Long medicineId, @RequestParam Long recordId) {
        try {
            prescriptionService.update( prescription, recordId, medicineId);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> add(@RequestBody Prescription prescription, @RequestParam Long medicineId, @RequestParam Long recordId){
        try {
            prescriptionService.add(prescription, recordId, medicineId);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch ( Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 @GetMapping(path = "/getAllByRecordId/{recordId}")
    public ResponseEntity<?> getAllByRecordId(@PathVariable Long recordId){
        try {
            return new ResponseEntity<>(prescriptionService.getAllByRecordId(recordId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
