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

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;



public class InventaireActivity extends AppCompatActivity {

    //ListView listView;
    SQLiteDatabase db;
    List<Article> articles = new ArrayList<Article>();
        /*
        listView = (ListView) findViewById(R.id.listView);
        try {
            get("http://localhost/php/testDb.php");
        } catch (IOException e) {
            e.printStackTrace();
        }
        downloadJSON("http://localhost/php/testDb.php");
         */


    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

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

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        /*final ArrayAdapter<Article> adapter = new ArrayAdapter<Article>(InventaireActivity.this,
                android.R.layout.simple_list_item_1, articles);*/
        listView.setAdapter(new CustomListAdapter(this,articles));
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

    /*
    private void downloadJSON(final String urlWebService) {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s) && s!=null) {
                    //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    try {
                        loadIntoListView(s);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader;
                    InputStreamReader inputStreamReader =new InputStreamReader(con.getInputStream());
                    bufferedReader = new BufferedReader(inputStreamReader);
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] stocks = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            stocks[i] = obj.getString("libArticle") + " " + obj.getString("qteArticle");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stocks);
        listView.setAdapter(arrayAdapter);
    }

private final OkHttpClient client = new OkHttpClient();

    public String get(String url) throws IOException {
        // Prepare the request.
        Request request = new Request.Builder().url(url).build();
        // Execute the request.
        Response response = client.newCall(request).execute();
        // Get the result.
        return response.body().string();
    }*/
