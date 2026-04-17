package com.devsenior.controllers;

import com.devsenior.exceptions.PatientNotFoundException;
import com.devsenior.models.Patient;
import com.devsenior.services.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
class PatientController {
    private final PatientService service;

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.ok(this.service.getPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getId(@PathVariable long id) {
        var patient = this.service.getPatient(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Patient patient) {
        this.service.save(patient);
        return ResponseEntity.created(URI.create("/patients/")).body("Paciente agregado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable long id,
                                          @Valid @RequestBody Patient patient) {
        try {
            boolean updated = service.updatePatient(id, patient);
            if (!updated) {
                throw new PatientNotFoundException("Paciente con id " + id + " no encontrado");
            }
            return ResponseEntity.created(URI.create("patients/" + id)).body(service.getPatient(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> delete(@PathVariable long id) {
        this.service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
