package com.example.ProdavnicaObuce.Obuca;

public class PretragaObuceProjection {
    String naziv, grad;
    Boolean prodato;
    Integer velicina;

    public PretragaObuceProjection() {
    }

    public PretragaObuceProjection(String grad, Boolean prodato) {
        this.grad = grad;
        this.prodato = prodato;
    }

    public PretragaObuceProjection(String naziv, String grad, Boolean prodato, Integer velicina) {
        this.naziv = naziv;
        this.grad = grad;
        this.prodato = prodato;
        this.velicina = velicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Boolean getProdato() {
        return prodato;
    }

    public void setProdato(Boolean prodato) {
        this.prodato = prodato;
    }

    public Integer getVelicina() {
        return velicina;
    }

    public void setVelicina(Integer velicina) {
        this.velicina = velicina;
    }
}
