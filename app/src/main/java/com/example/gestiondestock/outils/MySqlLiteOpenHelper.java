package com.example.gestiondestock.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlLiteOpenHelper extends SQLiteOpenHelper {


    private String magasinier ="create table magasinier("
            +"idMagasinier TEXT PRIMARY KEY,"
            +"nomMagasinier TEXT NOT NULL,"
            +"prenomMagasinier TEXT NOT NULL,"
            +"telMagasinier INTEGER,"
            +"adresseMagasinier TEXT,"
            +"cpMagasinier INTEGER,"
            +"villeMagasinier TEXT)";

    private String article="create table article("
            +"idArticle TEXT PRIMARY KEY,"
            +"libArticle TEXT NOT NULL,"
            +"qteArticle INTEGER NOT NULL,"
            +"description TEXT,"
            +"image TEXT,"
            +"stockMin INTEGER NOT NULL,"
            +"stockMax INTEGER NOT NULL,"
            +"prix INTEGER NOT NULL)";

    private String fournisseur="create table fournisseur("
            +"idFournisseur TEXT PRIMARY KEY,"
            +"nomFournisseur TEXT NOT NULL,"
            +"prenomFournisseur TEXT NOT NULL,"
            +"telFournisseur INTEGER,"
            +"adresseFournisseur TEXT,"
            +"cpFournisseur INTEGER,"
            +"villeFournisseur INTEGER)";
    /**
     * constructor
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySqlLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * si changement de BD
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(article);
        db.execSQL(fournisseur);
        db.execSQL(magasinier);
    }

    /**
     * si changement de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
