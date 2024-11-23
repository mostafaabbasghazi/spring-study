package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class User {

    @NotNull(message = "الاسم لا يمكن أن يكون فارغًا")
    @Size(min = 2, max = 50, message = "الاسم يجب أن يتراوح بين 2 و 50 حرفًا")
    private String name;

    @Email(message = "يرجى إدخال عنوان بريد إلكتروني صالح")
    private String email;

    @NotNull(message = "العمر لا يمكن أن يكون فارغًا")
    @Min(value = 18, message = "يجب أن يكون العمر 18 عامًا أو أكثر")
    @Max(value = 120, message = "يجب أن يكون العمر 120 عامًا أو أقل")
    private Integer age;
    @Id
    private Long id;
    // Getter and Setter methods
}
