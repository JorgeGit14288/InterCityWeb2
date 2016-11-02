/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.setjson;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
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

        String myURL = "http://192.168.5.44/app_dev.php/cus/editaccount/"+usuario;

        String query = myURL;
        String jsons = objJson2.toString();

        

    }

}
