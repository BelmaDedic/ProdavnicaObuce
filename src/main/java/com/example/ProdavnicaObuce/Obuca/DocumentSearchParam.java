package com.example.ProdavnicaObuce.Obuca;

public class DocumentSearchParam {
    private String boja, nazivProdavnica, imeUser;

    public DocumentSearchParam() {
    }

    public DocumentSearchParam(String boja, String nazivProdavnica, String imeUser) {
        this.boja = boja;
        this.nazivProdavnica = nazivProdavnica;
        this.imeUser = imeUser;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getNazivProdavnica() {
        return nazivProdavnica;
    }

    public void setNazivProdavnica(String nazivProdavnica) {
        this.nazivProdavnica = nazivProdavnica;
    }

    public String getImeUser() {
        return imeUser;
    }

    public void setImeUser(String imeUser) {
        this.imeUser = imeUser;
    }
}
