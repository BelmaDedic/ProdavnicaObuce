package com.example.ProdavnicaObuce.Obuca;

public class ProdavnicaProizvodjacProjection {
    private Integer id;
    private String naziv, adresa, grad;

    public ProdavnicaProizvodjacProjection() {
    }

    public ProdavnicaProizvodjacProjection(Integer id, String naziv, String adresa, String grad) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }
}
