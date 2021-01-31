package com.example.gestiondestock.vue;


import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondestock.R;

import com.example.gestiondestock.modele.Article;
import com.example.gestiondestock.modele.CustomListAdapter;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;



public class InventaireActivity extends AppCompatActivity {

    //ListView listView;
    SQLiteDatabase db;
    List<Article> articles = new ArrayList<Article>();


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventaire);

        try {
            db = openOrCreateDatabase("gestion_app", SQLiteDatabase.CREATE_IF_NECESSARY, null);
            showArticle();

        } catch (SQLException e)
        {
        }
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this,articles));

    }

    public void delete(int id){
        db.delete("article","id ="+id,null);
    }

    public void showArticle(){
        Cursor c=db.rawQuery("SELECT * FROM Article",null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            Article article = new Article(c.getString(1),c.getInt(2),c.getString(3),c.getString(4),c.getInt(5),c.getInt(6),c.getInt(7));
            articles.add(article);
            c.moveToNext();
        }
        c.close();
    }
}


