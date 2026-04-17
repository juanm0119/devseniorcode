package com.devsenior.repositores;

import com.devsenior.models.Patient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PatientRepository {
    private static final AtomicLong COUNTER = new AtomicLong(4L);
    private static final List<Patient> PATIENTS = new ArrayList<>();

    public PatientRepository() {
        PATIENTS.add(new Patient(1L, "Carlos", "García", "1045678901",
                LocalDate.of(1990, 5, 15), 35, "carlos@correo.com",
                "3001234567", "Calle 10 # 5-32, Bogotá", "O+", "Alergia a la penicilina"));

        PATIENTS.add(new Patient(2L, "María", "López", "1098765432",
                LocalDate.of(1985, 8, 22), 40, "maria@correo.com",
                "3019876543", "Carrera 15 # 8-20, Medellín", "A-", "Asma leve"));

        PATIENTS.add(new Patient(3L, "Andrés", "Martínez", "1023456789",
                LocalDate.of(2000, 3, 10), 25, "andres@correo.com",
                "3024567891", "Avenida 6 # 12-45, Cali", "B+", null));
    }

    public List<Patient> findAll() {
        return PATIENTS;
    }

    public Optional<Patient> getById(long id) {
        return PATIENTS.stream().filter(patient -> patient.getId() == id)
                .findFirst();
    }

    public void save(Patient patient) {
        patient.setId(COUNTER.getAndIncrement());
        PATIENTS.add(patient);
    }

    public boolean remove(long id) {
        return PATIENTS.removeIf(patient -> patient.getId() == id);
    }

}
