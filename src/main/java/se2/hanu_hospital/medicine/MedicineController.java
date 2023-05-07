package se2.hanu_hospital.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = {"/medicine"})
public class MedicineController {
    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<?> getMedicines (){
        try {
            return new ResponseEntity<>(medicineService.getMedicine(), HttpStatus.OK);

        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addMedicine(@RequestBody Medicine medicine){
        try {
            medicineService.addMedicine(medicine);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public ResponseEntity<?> deleteMedicine(@PathVariable("id") Long id){
        try{
            medicineService.deleteMedicine(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/isExprired/{id}")
    public ResponseEntity<?> isExpired(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(medicineService.isExpired(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<?> getMedicineById (@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(medicineService.getMedicineById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateMedicine(@RequestBody Medicine medicine){
        try {
            medicineService.updateMedicine(medicine);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
