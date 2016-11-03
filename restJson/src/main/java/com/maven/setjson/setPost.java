/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.setjson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author jorge
 */
public class setPost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {

        String respuesta = null;
        String myUrl = "http://192.168.5.44/app_dev.php/cus/setaccount/" + 29 + ".json";
        URL url = new URL(myUrl);
        try {

           
            //abrimos la conexiÃ³n
            URLConnection conn = url.openConnection();
            //especificamos que vamos a escribir
            conn.setDoOutput(true);

            String data = URLEncoder.encode("firstName", "UTF-8") + "=" + URLEncoder.encode("Jorge Roberto", "UTF-8");
            data += "&" + URLEncoder.encode("lastName", "UTF-8") + "=" + URLEncoder.encode("Fuentes Hernandez", "UTF-8");
            data += "&" + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode("6ta. calle 0-97 z6", "UTF-8");
            data += "&" + URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode("Quetzaltenango", "UTF-8");
            data += "&" + URLEncoder.encode("postalCode", "UTF-8") + "=" + URLEncoder.encode("84", "UTF-8");
            data += "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode("jorge@gmail.com", "UTF-8");
            data += "&" + URLEncoder.encode("languaje", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8");
            data += "&" + URLEncoder.encode("notifyEmail", "UTF-8") + "=" + URLEncoder.encode("true", "UTF-8");
            data += "&" + URLEncoder.encode("notifyFlag", "UTF-8") + "=" + URLEncoder.encode("true", "UTF-8");

//escribimos
            try ( //obtenemos el flujo de escritura
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())) {
                //escribimos
                wr.write(data);
                wr.flush();

//cerramos la conexiÃ³n
            }

            //obtenemos el flujo de lectura
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String linea;
            //procesamos al salida
            while ((linea = rd.readLine()) != null) {
                respuesta += linea;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(respuesta);
        // TODO code application logic here
    }

}
