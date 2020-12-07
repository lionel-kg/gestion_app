package com.example.gestiondestock.vue;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.gestiondestock.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init(){
        ecouteFournisseur();
        ecouteInventaire();
        ecouteTransaction();
    }
    public void ecouteInventaire(){
        ((ImageView) findViewById(R.id.inventaire)).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, InventaireActivity.class);
                startActivity(intent);
            }
        });
    }
    public void ecouteFournisseur(){
        ((ImageView) findViewById(R.id.fournisseur)).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FournisseurActivity.class);
                startActivity(intent);
            }
        });
    }
    public void ecouteTransaction(){
        ((ImageView) findViewById(R.id.transaction)).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, TransactionActivity.class);
                startActivity(intent);
            }
        });
    }

}