package com.example.gestiondestock.vue;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestiondestock.R;

public class AddFournisseurActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fournisseur);
        try {
            db = openOrCreateDatabase("gestion_app", SQLiteDatabase.CREATE_IF_NECESSARY, null);

            add();
        } catch (SQLException e)
        {
        }
    }
    public void add(){
        EditText nom = (EditText) findViewById(R.id.nomFour);
        EditText prenom = (EditText) findViewById(R.id.prenomFour);
        EditText adresse = (EditText) findViewById(R.id.adresseFour);
        EditText email = (EditText) findViewById(R.id.emailFour);
        EditText telephone = (EditText) findViewById(R.id.telFour);
        EditText cp = (EditText) findViewById(R.id.cpFour);
        EditText ville = (EditText) findViewById(R.id.villeFour);
        EditText description = (EditText) findViewById(R.id.descFour);



        ((Button) findViewById(R.id.submitFour)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                ContentValues values = new ContentValues();
                values.put("nomFournisseur", nom.getText().toString());
                values.put("prenomFournisseur", prenom.getText().toString());
                values.put("emailFournisseur", email.getText().toString());
                values.put("telFournisseur", telephone.getText().toString());
                values.put("adresseFournisseur", adresse.getText().toString());
                values.put("cpFournisseur", cp.getText().toString());
                values.put("villeFournisseur", ville.getText().toString());
                values.put("description", description.getText().toString());

                if((db.insert("fournisseur", null, values))!=-1)
                {
                    Toast.makeText(AddFournisseurActivity.this, "Record Successfully Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddFournisseurActivity.this, "Insert Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
