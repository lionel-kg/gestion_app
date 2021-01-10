package com.example.gestiondestock.modele;

public class Fournisseur {

    private int idFournisseur;
    private String nomFournisseur;
    private String prenomFournisseur;
    private String emailFournisseur;
    private int telFournisseur;
    private String adresseFournisseur;
    private int cpFournisseur;
    private String villeFournisseur;
    private String description;

    public Fournisseur(String nomFournisseur, String prenomFournisseur, int telFournisseur, String emailFournisseur, String adresseFournisseur, int cpFournisseur, String villeFournisseur, String description) {
        this.nomFournisseur = nomFournisseur;
        this.prenomFournisseur = prenomFournisseur;
        this.telFournisseur = telFournisseur;
        this.emailFournisseur = emailFournisseur;
        this.adresseFournisseur = adresseFournisseur;
        this.cpFournisseur = cpFournisseur;
        this.villeFournisseur = villeFournisseur;
        this.description = description;
    }
    public int getIdFournisseur() {
        return idFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getPrenomFournisseur() {
        return prenomFournisseur;
    }

    public void setPrenomFournisseur(String prenomFournisseur) {
        this.prenomFournisseur = prenomFournisseur;
    }

    public String getEmailFournisseur() {
        return emailFournisseur;
    }

    public void setEmailFournisseur(String emailFournisseur) {
        this.emailFournisseur = emailFournisseur;
    }

    public int getTelFournisseur() {
        return telFournisseur;
    }

    public void setTelFournisseur(int telFournisseur) {
        this.telFournisseur = telFournisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public int getCpFournisseur() {
        return cpFournisseur;
    }

    public void setCpFournisseur(int cpFournisseur) {
        this.cpFournisseur = cpFournisseur;
    }

    public String getVilleFournisseur() {
        return villeFournisseur;
    }

    public void setVilleFournisseur(String villeFournisseur) {
        this.villeFournisseur = villeFournisseur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return this.nomFournisseur;
    }




}
