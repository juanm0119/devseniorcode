package com.devsenior.services;

import com.devsenior.exceptions.DoctorNotFoundException;
import com.devsenior.models.Doctor;
import com.devsenior.repositores.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repository;

    public List<Doctor> getDoctors() {
        return this.repository.findAll();
    }

    public Doctor getDoctor(long id) {
        return this.repository.getById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Medico con id " + id + " no encontrado"));
    }

    public void save(Doctor newDoctor) {
        this.repository.save(newDoctor);
    }

    public boolean updateDoctor(long id, Doctor updatedDoctor) {
        var found = this.repository.getById(id);
        if (found.isPresent()) {
            Doctor existing = found.get();
            existing.setFirstName(updatedDoctor.getFirstName());
            existing.setLastName(updatedDoctor.getLastName());
            existing.setLicenseNumber(updatedDoctor.getLicenseNumber());
            existing.setSpecialty(updatedDoctor.getSpecialty());
            existing.setYearsOfExperience(updatedDoctor.getYearsOfExperience());
            existing.setEmail(updatedDoctor.getEmail());
            existing.setPhoneNumber(updatedDoctor.getPhoneNumber());
            existing.setConsultationFee(updatedDoctor.getConsultationFee());
            existing.setIsActive(updatedDoctor.getIsActive());
            return true;
        }

        return false;
    }

    public void remove(long id) {
        if (!this.repository.remove(id)) {
            throw new DoctorNotFoundException("Medico con id " + id + " no encontrado");
        }
    }
}
