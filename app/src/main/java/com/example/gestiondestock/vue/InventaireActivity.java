package com.example.gestiondestock.vue;


import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondestock.R;
import com.example.gestiondestock.controleur.Controle;
import com.example.gestiondestock.modele.AccesLocal;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class InventaireActivity extends AppCompatActivity {

    //ListView listView;
    SQLiteDatabase db;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventaire);
        this.controle = Controle.getInstance(this);

        }
        /*
        listView = (ListView) findViewById(R.id.listView);
        try {
            get("http://localhost/php/testDb.php");
        } catch (IOException e) {
            e.printStackTrace();
        }
        downloadJSON("http://localhost/php/testDb.php");
         */
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
