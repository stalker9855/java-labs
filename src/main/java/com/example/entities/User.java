package com.example.entities;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.example.config.PasswordHash;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "\"users\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String username) {
        this.name = username;
    }

    public void setPassword(String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.password = PasswordHash.hashPassword(password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
