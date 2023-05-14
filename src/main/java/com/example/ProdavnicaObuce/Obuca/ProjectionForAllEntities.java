package com.example.ProdavnicaObuce.Obuca;

public class ProjectionForAllEntities {
    private String nazivObuca, bojaObuce, imeUser, username, proizvodjac, sjedisteProizvodjaca, nazivProdavnice,
            adresaProdavnice, nazivGrada, postanskiBroj, nazivDrzave, valuta;

    public ProjectionForAllEntities() {
    }

    public ProjectionForAllEntities(String nazivObuca, String bojaObuce, String imeUser, String username,
                                    String proizvodjac, String sjedisteProizvodjaca, String nazivProdavnice,
                                    String adresaProdavnice, String nazivGrada, String postanskiBroj,
                                    String nazivDrzave, String valuta) {
        this.nazivObuca = nazivObuca;
        this.bojaObuce = bojaObuce;
        this.imeUser = imeUser;
        this.username = username;
        this.proizvodjac = proizvodjac;
        this.sjedisteProizvodjaca = sjedisteProizvodjaca;
        this.nazivProdavnice = nazivProdavnice;
        this.adresaProdavnice = adresaProdavnice;
        this.nazivGrada = nazivGrada;
        this.postanskiBroj = postanskiBroj;
        this.nazivDrzave = nazivDrzave;
        this.valuta = valuta;
    }

    public String getNazivObuca() {
        return nazivObuca;
    }

    public void setNazivObuca(String nazivObuca) {
        this.nazivObuca = nazivObuca;
    }

    public String getBojaObuce() {
        return bojaObuce;
    }

    public void setBojaObuce(String bojaObuce) {
        this.bojaObuce = bojaObuce;
    }

    public String getImeUser() {
        return imeUser;
    }

    public void setImeUser(String imeUser) {
        this.imeUser = imeUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getSjedisteProizvodjaca() {
        return sjedisteProizvodjaca;
    }

    public void setSjedisteProizvodjaca(String sjedisteProizvodjaca) {
        this.sjedisteProizvodjaca = sjedisteProizvodjaca;
    }

    public String getNazivProdavnice() {
        return nazivProdavnice;
    }

    public void setNazivProdavnice(String nazivProdavnice) {
        this.nazivProdavnice = nazivProdavnice;
    }

    public String getAdresaProdavnice() {
        return adresaProdavnice;
    }

    public void setAdresaProdavnice(String adresaProdavnice) {
        this.adresaProdavnice = adresaProdavnice;
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getNazivDrzave() {
        return nazivDrzave;
    }

    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }
}
