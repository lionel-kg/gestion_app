package com.example.gestiondestock.vue;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondestock.R;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FournisseurActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseur);
        try {
            db = openOrCreateDatabase("gestion_app", SQLiteDatabase.CREATE_IF_NECESSARY, null);
            showFournisseur();
        } catch (
        SQLException e) {
        }
    }
    public void createLinearView(String nom,Integer id){
        LinearLayout lv = ((LinearLayout) findViewById(R.id.container));
        int txt = lv.getOrientation();
        String txt2 = String.valueOf(txt);
        int duration = Toast.LENGTH_SHORT;
        Toast t = Toast.makeText(this, txt2,duration);
        t.show();
        LinearLayout lv2 =  new LinearLayout(this);
        LinearLayout lh = new LinearLayout(this);
        lv2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));
        lv2.setOrientation(LinearLayout.VERTICAL);
        lv2.setGravity(LinearLayout.HORIZONTAL|LinearLayout.VERTICAL);

        lh.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));
        lh.setOrientation(LinearLayout.VERTICAL);
        lh.setGravity(LinearLayout.HORIZONTAL|LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        tv.setText(nom);
        String idTv = String.valueOf(tv.getId());
        Toast.makeText(this,idTv,Toast.LENGTH_SHORT).show();
        //lv2.addView(tv);
        //lh.addView(tv);
        lv.addView(tv);
    }
    public void showFournisseur(){
        Cursor c=db.rawQuery("SELECT * FROM fournisseur",null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            createLinearView(c.getString(1),c.getInt(0));
            c.moveToNext();
        }
        c.close();

    }
}
