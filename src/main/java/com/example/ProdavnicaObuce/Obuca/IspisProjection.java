package com.example.ProdavnicaObuce.Obuca;

public class IspisProjection {
    private String ime;
    private Double cijena;
    private String grad;

    public IspisProjection() {
    }

    public IspisProjection(String ime, Double cijena, String grad) {
        this.ime = ime;
        this.cijena = cijena;
        this.grad = grad;
    }

    public IspisProjection(Double cijena, String grad) {
        this.cijena = cijena;
        this.grad = grad;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }
}
