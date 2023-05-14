package com.example.ProdavnicaObuce.Obuca;

public class ProizvodjacUser {
    private Integer id;
    private String ime, prezime, email, grad;

    public ProizvodjacUser() {
    }

    public ProizvodjacUser(Integer id, String ime, String prezime, String email, String grad) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.grad = grad;
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

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }
}
