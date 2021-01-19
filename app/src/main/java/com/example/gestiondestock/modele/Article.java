package com.example.gestiondestock.modele;

public class Article {

    //propriétés
    private int id_article;
    private String lib_article;
    private int qteArticle;
    private String description;
    private String image;
    private int stockmin;
    private int stockmax;
    private int prix;

    /**
     * Création de l'article
     * @param lib_article
     * @param qteArticle
     * @param description
     * @param image
     * @param stockmin
     * @param stockmax
     * @param prix
     */
    public Article(String lib_article, int qteArticle, String description, String image, int stockmin, int stockmax, int prix) {
        this.lib_article = lib_article;
        this.qteArticle = qteArticle;
        this.description = description;
        this.image = image;
        this.stockmin = stockmin;
        this.stockmax = stockmax;
        this.prix = prix;
    }

    /**
     * récupération ID
     * @return l'ID
     */
    public int getId_article() {
        return id_article;
    }

    /**
     * récupération du libellé
     * @return le lib
     */
    public String getLib_article() {
        return lib_article;
    }

    /**
     * Création d'un libellé
     * @param lib_article
     */
    public void setLib_article(String lib_article) {
        this.lib_article = lib_article;
    }

    /**
     * récupération de la quantité d'article
     * @return la quantité
     */
    public int getQteArticle() {
        return qteArticle;
    }

    /**
     * Création de la quantité d'article
     * @param qteArticle
     */
    public void setQteArticle(int qteArticle) {
        this.qteArticle = qteArticle;
    }

    /**
     * récupération de la description de l'article
     * @return la description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Création de la description de l'article
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * récupération de l'image de l'article
     * @return l'image
     */
    public String getImage() {
        return image;
    }

    /**
     * création de l'image
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * récupération du stock minim
     * @return le stock mini
     */
    public int getStockmin() {
        return stockmin;
    }

    /**
     * création du stock mini
     * @param stockmin
     */
    public void setStockmin(int stockmin) {
        this.stockmin = stockmin;
    }

    /**
     * récupération du stock maxi
     * @return le stock maxi
     */
    public int getStockmax() {
        return stockmax;
    }

    /**
     * Création du stock maxi
     * @param stockmax
     */
    public void setStockmax(int stockmax) {
        this.stockmax = stockmax;
    }

    /**
     * récupération du prix
     * @return le prix
     */
    public int getPrix() {
        return prix;
    }

    /**
     * création du prix
     * @param prix
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }
}
