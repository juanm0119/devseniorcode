package com.devsenior.services;

import com.devsenior.exceptions.DoctorNotFoundException;
import com.devsenior.exceptions.PatientNotFoundException;
import com.devsenior.models.Patient;
import com.devsenior.repositores.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;

    public List<Patient> getPatients() {
        return this.repository.findAll();
    }

    public Patient getPatient(long id) {
        return this.repository.getById(id)
                .orElseThrow(() -> new PatientNotFoundException("Paciente con id " + id + " no encontrado"));
    }

    public void save(Patient newPatient) {
        this.repository.save(newPatient);
    }

    public boolean updatePatient(Long id, Patient updatedPatient) {
        var found = this.repository.getById(id);
        if (found.isPresent()) {
            Patient existing = found.get();
            existing.setFirstName(updatedPatient.getFirstName());
            existing.setLastName(updatedPatient.getLastName());
            existing.setDocumentNumber(updatedPatient.getDocumentNumber());
            existing.setDateOfBirth(updatedPatient.getDateOfBirth());
            existing.setAge(updatedPatient.getAge());
            existing.setEmail(updatedPatient.getEmail());
            existing.setPhoneNumber(updatedPatient.getPhoneNumber());
            existing.setAddress(updatedPatient.getAddress());
            existing.setBloodType(updatedPatient.getBloodType());
            existing.setMedicalNotes(updatedPatient.getMedicalNotes());
            return true;
        }
        return false;
    }

    public void remove(long id) {
        if (!this.repository.remove(id)) {
            throw new DoctorNotFoundException("Paciente con id " + id + " no encontrado");
        }
    }
}
