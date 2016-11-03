/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.setjson;

import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jorge
 */
public class setJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException, ProtocolException, MalformedURLException, IOException {
        // TODO code application logic here

        String user = "502-41109321";
        AccountLight account = new AccountLight();
        account.setAddress("0-91");
        account.setCity("Quetzaltenango");
        account.setEmail("jorge@gmail.com");
        account.setFirstName("Jorge");
        account.setLastName("Fuentes");
        account.setLanguaje_id(1);
        account.setNotifyEmail(true);
        account.setNotityFlag(true);
        account.setPostalCode("88");

        System.out.println("ENVIANDO UN ARRAY JSON");
        String usuario = user.replace("-", "");

        System.out.println("ENVIANDO UN ARRAY JSON");
        Gson gson = new Gson();
        JSONObject objJson = new JSONObject();
        String json = gson.toJson(account);

        JSONObject objJson2 = new JSONObject(json);

        System.out.println("DATOS JSON A ENVIAR " + objJson2.toString());

        //  String url = "http://192.168.5.44/app_dev.php/cus/editaccount/" + usuario;
        String jsons = objJson2.toString();

        //leemos dese url para ver si existe el objeto o no.
        URL URL = new URL("http://192.168.5.44/app_dev.php/cus/getaccount/50241109321.json");
        BufferedReader in = new BufferedReader(new InputStreamReader(URL.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();

        /// probamos enviar ahora a la url
        try {
            URL myURL = new URL("http://youtube.com/");
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            System.out.println("Se conecto a la url "+myURL);
        } catch (MalformedURLException e) {
            // new URL() failed
            e.printStackTrace();
            // ...
        } catch (IOException e) {
            // openConnection() failed
            e.printStackTrace();
            // ...
        }

    }

}
