package com.example.gestiondestock.vue;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondestock.R;
import com.example.gestiondestock.modele.Article;
import com.example.gestiondestock.modele.Fournisseur;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FournisseurActivity extends AppCompatActivity {
    SQLiteDatabase db;
    List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

    @SuppressLint("WrongConstant")
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
        ListView listView = (ListView)findViewById(R.id.listViewFour);

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        final ArrayAdapter<Fournisseur> adapter = new ArrayAdapter<Fournisseur>(FournisseurActivity.this,
                android.R.layout.simple_list_item_1, fournisseurs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(showOption);
    }

    AdapterView.OnItemClickListener showOption = new AdapterView.OnItemClickListener() {

        /**
         * Callback method to be invoked when an item in this AdapterView has
         * been clicked.
         * <p>
         * Implementers can call getItemAtPosition(position) if they need
         * to access the data associated with the selected item.
         *
         * @param parent   The AdapterView where the click happened.
         * @param view     The view within the AdapterView that was clicked (this
         *                 will be a view provided by the adapter)
         * @param position The position of the view in the adapter.
         * @param id       The row id of the item that was clicked.
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Spinner option = new Spinner(getApplicationContext());
            String[] items = new String[]{"edit", "delete"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(FournisseurActivity.this, android.R.layout.simple_spinner_dropdown_item, items);
            option.setAdapter(adapter);
        }
    };

    /*public void createLinearView(String nom,Integer id){
        LinearLayout lv = ((LinearLayout) findViewById(R.id.container));
        int txt = lv.getOrientation();
        String txt2 = String.valueOf(txt);
        int duration = Toast.LENGTH_SHORT;
        Toast t = Toast.makeText(this, txt2,duration);
        t.show();
        LinearLayout lh = new LinearLayout(this);

        lh.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));
        lh.setOrientation(LinearLayout.HORIZONTAL);
        lh.setGravity(LinearLayout.HORIZONTAL|LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        tv.setText(nom);
        tv.setHeight(120);
        String idTv = String.valueOf(tv.getId());
        Toast.makeText(this,idTv,Toast.LENGTH_SHORT).show();
        lh.addView(tv);
        lv.addView(lh);
    }*/
    public void showFournisseur(){
        Cursor c=db.rawQuery("SELECT * FROM fournisseur",null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            Fournisseur fournisseur = new Fournisseur(c.getString(1),c.getString(2),c.getInt(3),c.getString(4),c.getString(5),c.getInt(6),c.getString(7),c.getString(8));
            fournisseurs.add(fournisseur);
            c.moveToNext();
        }
        c.close();

    }
}
