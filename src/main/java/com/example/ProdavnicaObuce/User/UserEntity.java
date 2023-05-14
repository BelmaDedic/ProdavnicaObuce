package com.example.ProdavnicaObuce.User;

import com.example.ProdavnicaObuce.Obuca.ObucaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime, prezime, email, username, password;

    @JsonIgnore
    @OneToMany(targetEntity = ObucaEntity.class, mappedBy = "user")
    private List<ObucaEntity> obuca = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(Integer id, String ime, String prezime, String email, String username, String password,
                      List<ObucaEntity> obuca) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.username = username;
        this.password = password;
        this.obuca = obuca;
    }

    public UserEntity(String ime, String prezime, String email, String username, String password,
                      List<ObucaEntity> obuca) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.username = username;
        this.password = password;
        this.obuca = obuca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ObucaEntity> getObuca() {
        return obuca;
    }

    public void setObuca(List<ObucaEntity> obuca) {
        this.obuca = obuca;
    }
}
