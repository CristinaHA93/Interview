package com.example.usersapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "user_detail")
@Table(name = "user_detail")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Name is mandatory")
    private String phone;

    @NotBlank(message = "Name is mandatory")
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Password is mandatory") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Name is mandatory") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Name is mandatory") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Name is mandatory") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Name is mandatory") String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
