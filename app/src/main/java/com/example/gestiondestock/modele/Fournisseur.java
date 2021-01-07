package com.example.gestiondestock.modele;

public class Fournisseur {

    private int idFournisseur;
    private String NomFournisseur;
    private String TelFournisseur;
    private String adresseFournisseur;
    private String cpFournisseur;
    private String villeFournisseur;

    public Fournisseur(String nomFournisseur, String telFournisseur, String adresseFournisseur, String cpFournisseur, String villeFournisseur) {
        NomFournisseur = nomFournisseur;
        TelFournisseur = telFournisseur;
        this.adresseFournisseur = adresseFournisseur;
        this.cpFournisseur = cpFournisseur;
        this.villeFournisseur = villeFournisseur;
    }
    public int getIdFournisseur() {
        return idFournisseur;
    }

    public String getNomFournisseur() {
        return NomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        NomFournisseur = nomFournisseur;
    }

    public String getTelFournisseur() {
        return TelFournisseur;
    }

    public void setTelFournisseur(String telFournisseur) {
        TelFournisseur = telFournisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public String getCpFournisseur() {
        return cpFournisseur;
    }

    public void setCpFournisseur(String cpFournisseur) {
        this.cpFournisseur = cpFournisseur;
    }

    public String getVillelFournisseur() {
        return villeFournisseur;
    }

    public void setVillelFournisseur(String villeFournisseur) {
        this.villeFournisseur = villeFournisseur;
    }




}