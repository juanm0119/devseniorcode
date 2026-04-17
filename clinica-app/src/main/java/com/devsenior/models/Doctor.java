package com.devsenior.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @NotBlank(message = "License number is required")
    @Size(min = 5, max = 20, message = "License number must be between 5 and 20 characters")

    private String licenseNumber;

    @NotBlank(message = "Specialty is required")
    @Size(max = 100, message = "Specialty must not exceed 100 characters")
    private String specialty;

    @NotNull(message = "Years of experience is required")
    @Min(value = 0, message = "Years of experience must be at least 0")
    @Max(value = 60, message = "Years of experience must not exceed 60")
    private Integer yearsOfExperience;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(min = 7, max = 15, message = "Phone number must be between 7 and 15 characters")
    private String phoneNumber;

    @NotNull(message = "Consultation fee is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Consultation fee must be greater than 0")
    @DecimalMax(value = "99999.99", message = "Consultation fee must not exceed 99999.99")
    private Double consultationFee;

    @NotNull(message = "Active status is required")
    private Boolean isActive;
}
