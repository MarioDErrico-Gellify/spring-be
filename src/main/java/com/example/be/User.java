package com.example.be;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

public class User {

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Min(0)
    private int age;

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @NotNull
    private String email;

    public User(@NotNull String name, int age, @NotNull String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
