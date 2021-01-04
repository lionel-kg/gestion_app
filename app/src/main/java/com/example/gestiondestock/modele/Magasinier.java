package com.example.gestiondestock.modele;

public class Magasinier {
    private int idMagasinier;
    private String NomMagasinier;
    private String TelMagasinier;
    private String adresseMagasinier;
    private String cpMagasinier;
    private String villeMagasinier;

    public Magasinier(String nomMagasinier, String telMagasinier, String adresseMagasinier, String cpMagasinier, String villeMagasinier) {
        NomMagasinier = nomMagasinier;
        TelMagasinier = telMagasinier;
        this.adresseMagasinier = adresseMagasinier;
        this.cpMagasinier = cpMagasinier;
        this.villeMagasinier = villeMagasinier;
    }

    public int getIdMagasinier() {
        return idMagasinier;
    }

    public String getNomMagasinier() {
        return NomMagasinier;
    }

    public void setNomMagasinier(String nomMagasinier) {
        NomMagasinier = nomMagasinier;
    }

    public String getTelMagasinier() {
        return TelMagasinier;
    }

    public void setTelMagasinier(String telMagasinier) {
        TelMagasinier = telMagasinier;
    }

    public String getAdresseMagasinier() {
        return adresseMagasinier;
    }

    public void setAdresseMagasinier(String adresseMagasinier) {
        this.adresseMagasinier = adresseMagasinier;
    }

    public String getCpMagasinier() {
        return cpMagasinier;
    }

    public void setCpMagasinier(String cpMagasinier) {
        this.cpMagasinier = cpMagasinier;
    }

    public String getVilleMagasinier() {
        return villeMagasinier;
    }

    public void setVilleMagasinier(String villeMagasinier) {
        this.villeMagasinier = villeMagasinier;
    }
}