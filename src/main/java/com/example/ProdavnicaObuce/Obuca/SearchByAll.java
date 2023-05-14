package com.example.ProdavnicaObuce.Obuca;

public class SearchByAll {
    private String nazivObuca, imeUser, proizvodjac, nazivProdavnice, nazivGrada, nazivDrzave;

    public SearchByAll() {
    }

    public SearchByAll(String nazivObuca, String imeUser, String proizvodjac, String nazivProdavnice,
                       String nazivGrada, String nazivDrzave) {
        this.nazivObuca = nazivObuca;
        this.imeUser = imeUser;
        this.proizvodjac = proizvodjac;
        this.nazivProdavnice = nazivProdavnice;
        this.nazivGrada = nazivGrada;
        this.nazivDrzave = nazivDrzave;
    }

    public String getNazivObuca() {
        return nazivObuca;
    }

    public void setNazivObuca(String nazivObuca) {
        this.nazivObuca = nazivObuca;
    }

    public String getImeUser() {
        return imeUser;
    }

    public void setImeUser(String imeUser) {
        this.imeUser = imeUser;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getNazivProdavnice() {
        return nazivProdavnice;
    }

    public void setNazivProdavnice(String nazivProdavnice) {
        this.nazivProdavnice = nazivProdavnice;
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }

    public String getNazivDrzave() {
        return nazivDrzave;
    }

    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }
}
