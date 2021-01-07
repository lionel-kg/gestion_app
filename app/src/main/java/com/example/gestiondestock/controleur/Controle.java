package com.example.gestiondestock.controleur;

import android.content.Context;
import com.example.gestiondestock.modele.AccesLocal;


public final class Controle {

    private static AccesLocal accesLocal;
    private static Controle instance = null;



    private Controle(){
        super();
    }

    /**
     * creation de l'instance
     * @return une instance de Controle
     */
    public static final Controle getInstance(Context contexte){
        if(Controle.instance==null){
           Controle.instance = new Controle();
           accesLocal = new AccesLocal(contexte);
        }
        return Controle.instance;
    }
}
