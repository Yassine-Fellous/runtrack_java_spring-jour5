package com.example.demo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Personne {
    @NotNull(message = "Age is required.")
    @Min(value = 1, message = "Age must be at least 1.")
    @Max(value = 120, message = "Age must be at most 120.")
    private Integer age;

    @NotBlank
    private String name;

    public Personne() { }

    public Personne(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getAge() {
        return age.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
