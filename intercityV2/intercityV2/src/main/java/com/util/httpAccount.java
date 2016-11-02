/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.entitys.Account;
import com.entitys.AccountLight;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jorge
 */
public class httpAccount {

    public Account getAccountObject(String telefono) {
        System.out.println("OBTENER SOLO UN ARRAY DE CADENA JSON");
        //String myURL = "http://192.168.5.44/app_dev.php/cus/getaccount/50241109321.json";
         String myURL = "http://192.168.5.44/app_dev.php/cus/getaccount/"+telefono+".json";
        System.out.println("Requested URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());

                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }
        String jsonResult = sb.toString();
        // System.out.println(sb.toString());
        //System.out.println("\n\n--------------------OBTENEMOS OBJETO JSON NATIVO DE LA PAGINA, USAMOS EL ARRAY DATA---------------------------\n\n");
        JSONObject objJason = new JSONObject(jsonResult);
        JSONArray dataJson = new JSONArray();
        dataJson = objJason.getJSONArray("data");

        //System.out.println("objeto normal 1 "+dataJson.toString());
        //
        //
        // System.out.println("\n\n--------------------CREAMOS UN STRING JSON2 REEMPLAZANDO LOS CORCHETES QUE DAN ERROR---------------------------\n\n");
        String jsonString2 = dataJson.toString();
        String temp = dataJson.toString();
        temp = jsonString2.replace("[", "");
        jsonString2 = temp.replace("]", "");
        // System.out.println("new json string"+jsonString2);

        JSONObject objJson2 = new JSONObject(jsonString2);
        // System.out.println("el objeto simple json es " + objJson2.toString());

        // System.out.println("\n\n--------------------CREAMOS UN OBJETO JSON CON EL ARRAR ACCOUN---------------------------\n\n");
        String account1 = objJson2.optString("account");
        // System.out.println(account1);
        JSONObject objJson3 = new JSONObject(account1);
        //   System.out.println("el ULTIMO OBJETO SIMPLE ES  " + objJson3.toString());
        //   System.out.println("\n\n--------------------EMPEZAMOS A RECIBIR LOS PARAMETROS QUE HAY EN EL OBJETO JSON---------------------------\n\n");
        String firstName = objJson3.getString("first_name");
         System.out.println(firstName);
         System.out.println(objJson3.get("language_id"));
        //  System.out.println("\n\n--------------------TRATAMOS DE PASAR TODO EL ACCOUNT A OBJETO JAVA---------------------------\n\n");
        Gson gson = new Gson();
        Account account = gson.fromJson(objJson3.toString(), Account.class);
        //System.out.println(account.getFirst_name());
       // System.out.println(account.getCreation());
        account.setLanguaje_id(objJson3.get("language_id").toString());
        return account;
    }
    public void setAccountObject(AccountLight account, String user) {
        System.out.println("ENVIANDO UN ARRAY JSON");
        String usuario = user.replace("-", "");
        
        
        
        System.out.println("ENVIANDO UN ARRAY JSON");
        Gson gson = new Gson();
        JSONObject objJson = new JSONObject();
        String json = gson.toJson(account);
        
        JSONObject objJson2 = new JSONObject(json);
        
        System.out.println("DATOS JSON A ENVIAR "+objJson2.toString());
        
    }

}
