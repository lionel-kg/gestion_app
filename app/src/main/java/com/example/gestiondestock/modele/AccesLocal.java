package com.example.gestiondestock.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.IntegerRes;

import com.example.gestiondestock.outils.MySqlLiteOpenHelper;

import java.util.Date;

public class AccesLocal {
    private String nomBase = "gestion_app";
    private Integer versionBase = 1;
    private MySqlLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal(Context contexte){
        accesBD = new MySqlLiteOpenHelper(contexte,nomBase,null,versionBase);
    }


    public void delete(int id){
        bd = accesBD.getWritableDatabase();
        bd.delete("article","libArticle ="+id,null);
    }
}
    /**
     * ajout d'un profil dans la base de données
     * @param profil
     */
    /*public void addProfil(Profil profil){
        bd = accesBD.getWritableDatabase();
        String req = "insert into profil (datemesure,poids,taille,age,sexe) values";
        req += "(\""+profil.getDateMesure()+"\","+profil.getPoids()+","+profil.getTaille()+","+profil.getAge()+","+profil.getSexe()+")";
        bd.execSQL(req);
    }
*/
    /**
     * retourne le dernier profil de la base de données
     */
   /* public Profil currentProfil(){
        bd = accesBD.getReadableDatabase();
        Profil profil = null;
        String req = "SELECT * FROM profil ;";
        Cursor curseur = bd.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Date date = new Date();
            Integer poids = curseur.getInt(1);
            Integer taille = curseur.getInt(2);
            Integer age = curseur.getInt(3);
            Integer sexe = curseur.getInt(4);
            profil = new Profil(date,poids,taille,age,sexe);
        }
        curseur.close();
        return profil;
    }*/

