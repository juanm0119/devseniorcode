package com.devsenior.repositores;

import com.devsenior.models.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DoctorRepository {

    private static final AtomicLong COUNTER = new AtomicLong(4L);
    private static final List<Doctor> DOCTORS = new ArrayList<>();

    public DoctorRepository() {
        DOCTORS.add(new Doctor(1L, "Laura", "Ramírez", "MED-001",
                "Cardiología", 15, "laura@clinica.com",
                "3101112233", 120000.00, true));

        DOCTORS.add(new Doctor(2L, "Miguel", "Torres", "MED-002",
                "Neurología", 10, "miguel@clinica.com",
                "3102223344", 150000.00, true));

        DOCTORS.add(new Doctor(3L, "Sofía", "Herrera", "MED-003",
                "Pediatría", 8, "sofia@clinica.com",
                "3103334455", 95000.00, true));
    }

    public List<Doctor> findAll() {
        return DOCTORS;
    }

    public Optional<Doctor> getById(long id) {
        return DOCTORS.stream().filter(patient -> patient.getId() == id)
                .findFirst();
    }

    public void save(Doctor doctor) {
        doctor.setId(COUNTER.getAndIncrement());
        DOCTORS.add(doctor);
    }

    public boolean remove(long id) {
        return DOCTORS.removeIf(patient -> patient.getId() == id);
    }

}
