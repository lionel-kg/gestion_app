package com.example.gestiondestock.modele;

public class Article {


    private int id_article;
    private String lib_article;
    private int qteArticle;
    private String description;
    private String image;
    private int stockmin;
    private int stockmax;
    private int prix;

    public Article(String lib_article, int qteArticle, String description, String image, int stockmin, int stockmax, int prix) {
        this.lib_article = lib_article;
        this.qteArticle = qteArticle;
        this.description = description;
        this.image = image;
        this.stockmin = stockmin;
        this.stockmax = stockmax;
        this.prix = prix;
    }

    public int getId_article() {
        return id_article;
    }
    public String getLib_article() {
        return lib_article;
    }

    public void setLib_article(String lib_article) {
        this.lib_article = lib_article;
    }

    public int getQteArticle() {
        return qteArticle;
    }

    public void setQteArticle(int qteArticle) {
        this.qteArticle = qteArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStockmin() {
        return stockmin;
    }

    public void setStockmin(int stockmin) {
        this.stockmin = stockmin;
    }

    public int getStockmax() {
        return stockmax;
    }

    public void setStockmax(int stockmax) {
        this.stockmax = stockmax;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
