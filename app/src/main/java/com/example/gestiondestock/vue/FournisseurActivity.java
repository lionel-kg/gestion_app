package com.example.gestiondestock.vue;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondestock.R;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FournisseurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseur);
        createLinearView();
    }

    public void createLinearView(){
        LinearLayout lv = ((LinearLayout) findViewById(R.id.container));
        int txt = lv.getOrientation();
        String txt2 = String.valueOf(txt);
        int duration = Toast.LENGTH_SHORT;
        Toast t = Toast.makeText(this, txt2,duration);
        t.show();
        LinearLayout lv2 =  new LinearLayout(this);
        LinearLayout lh = new LinearLayout(this);
        for(int i = 0; i < 8;i++){
            lv2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));
            lv2.setOrientation(LinearLayout.VERTICAL);
            lv2.setGravity(LinearLayout.HORIZONTAL|LinearLayout.VERTICAL);

            lh.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));
            lh.setOrientation(LinearLayout.HORIZONTAL);
            lh.setGravity(LinearLayout.HORIZONTAL|LinearLayout.VERTICAL);

            TextView tv = new TextView(this);
            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
            tv.setText("hello world numero"+i);
            lv2.addView(tv);

        }
        lh.addView(lv2);
        lv.addView(lh);
    }
}