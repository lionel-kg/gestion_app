package com.example.gestiondestock.outils;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AccesHTTP extends AsyncTask<String,Integer,Long> {

    private ArrayList<NameValuePair> parametres;
    private String ret = null;
    private AsyncResponse delegate = null;
    /**
     * Constructeur
     */
    public AccesHTTP() {
        parametres = new ArrayList<NameValuePair>();
    }

    /**
     * ajout d'un parametre post
     * @param nom
     * @param valeur
     */
    public void addParam(String nom,String valeur){
        parametres.add(new BasicNameValuePair(nom,valeur));
    }

    /**
     * connexion en tâche de fond dans un thread séparé
     * @param strings
     * @return
     */
    @Override
    protected Long doInBackground(String... strings) {
        HttpClient cnxHttp = new DefaultHttpClient();
        HttpPost paramCnx = new HttpPost(strings[0]);
        try {
            // encodage des parametres
            paramCnx.setEntity(new UrlEncodedFormEntity(parametres));
            //connexion et envoie de parametres, attente de réponse
            HttpResponse response = cnxHttp.execute(paramCnx);
            // transformation de la reponse
            ret = EntityUtils.toString(response.getEntity());
        } catch (UnsupportedEncodingException e) {
            Log.d("Erreur encodage", "*************"+e.toString());
        } catch (ClientProtocolException e) {
            Log.d("Erreur protocole", "*************"+e.toString());
        } catch (IOException e) {
            Log.d("Erreur input/output", "*************"+e.toString());
        }
        return null;
    }
    @Override
    protected void onPostExecute(Long result){
        delegate.processFinish((ret.toString()));
    }
}
