package com.example.gestiondestock.vue;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.gestiondestock.R;
import com.example.gestiondestock.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    //private Controle controle;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        openBd();
        //this.controle = Controle.getInstance(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    public void init() {
        ecouteFournisseur();
        ecouteInventaire();
        ecouteTransaction();
        addFournisseur();
        addArticle();
        suppArticle();
        suppFournisseur();
    }

    // Ouverture des Activities correspondantes

    public void ecouteInventaire() {
        ((ImageView) findViewById(R.id.inventaire)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InventaireActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ecouteFournisseur() {
        ((ImageView) findViewById(R.id.fournisseur)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FournisseurActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ecouteTransaction() {
        ((ImageView) findViewById(R.id.transaction)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TransactionActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * ajout d'un fournisseur
     */
    public void addFournisseur() {
        ((ImageView) findViewById(R.id.addFournisseur)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddFournisseurActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"insertion du fournisseur", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * ajout d'un article
     */
    public void addArticle() {
        ((ImageView) findViewById(R.id.addArticle)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddArticleActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"insertion de l'article", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * suppression d'un article
     */
    public void suppArticle() {
        ((ImageView) findViewById(R.id.suppArticle)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("article",null,null);
                Toast.makeText(MainActivity.this,"les articles ont été supprimer", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void suppFournisseur() {
        ((ImageView) findViewById(R.id.suppFournisseur)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("fournisseur",null,null);
                Toast.makeText(MainActivity.this,"les fournisseur ont été supprimer", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * acces à la base de données
     */
    @SuppressLint("WrongConstant")
    public void openBd() {
        try {
            db = openOrCreateDatabase("gestion_app", SQLiteDatabase.CREATE_IF_NECESSARY, null);

            db.execSQL("create table article("
                    + "idArticle INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "libArticle TEXT NOT NULL,"
                    + "qteArticle INTEGER NOT NULL,"
                    + "description TEXT,"
                    + "image TEXT,"
                    + "stockMin INTEGER NOT NULL,"
                    + "stockMax INTEGER NOT NULL,"
                    + "prix INTEGER NOT NULL)");

            db.execSQL("create table fournisseur("
                    + "idFournisseur INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nomFournisseur TEXT NOT NULL,"
                    + "prenomFournisseur TEXT NOT NULL,"
                    + "telFournisseur INTEGER,"
                    + "emailFournisseur TEXT,"
                    + "adresseFournisseur TEXT,"
                    + "cpFournisseur INTEGER,"
                    + "villeFournisseur TEXT,"
                    + "description TEXT)");
        } catch (SQLException e) {
        }

    }
}