package com.example.ProdavnicaObuce.Obuca;

public class SearhObuca {
    private String proizvodjac, nazivObuce, grad, username;

    public SearhObuca() {
    }

    public SearhObuca(String proizvodjac, String nazivObuce, String grad, String username) {
        this.proizvodjac = proizvodjac;
        this.nazivObuce = nazivObuce;
        this.grad = grad;
        this.username = username;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getNazivObuce() {
        return nazivObuce;
    }

    public void setNazivObuce(String nazivObuce) {
        this.nazivObuce = nazivObuce;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
