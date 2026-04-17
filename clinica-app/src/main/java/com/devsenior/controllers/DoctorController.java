package com.devsenior.controllers;

import com.devsenior.exceptions.DoctorNotFoundException;
import com.devsenior.models.Doctor;
import com.devsenior.services.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
class DoctorController {

    private final DoctorService service;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(this.service.getDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getId(@PathVariable long id) {
        var doctor = this.service.getDoctor(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Doctor doctor) {
        this.service.save(doctor);
        return ResponseEntity.created(URI.create("/doctors/")).body("Medico agregado!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable long id,
                                          @Valid @RequestBody Doctor doctor) {
        try {
            boolean updated = service.updateDoctor(id, doctor);
            if (!updated) {
                throw new DoctorNotFoundException("Medico con id " + id + " no encontrado");
            }
            return ResponseEntity.created(URI.create("doctors/" + id)).body(service.getDoctor(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delete(@PathVariable long id) {
        this.service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
