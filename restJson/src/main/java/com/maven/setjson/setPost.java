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
        String myUrl = "http://192.168.5.44/app_dev.php/cus/setaccount/"+29+".json";
        URL url = new URL(myUrl);
        try {
            
            String firstName = "firstName=Jorge Roberto";
            String LastName ="lastName=Fuentes Hernandez";
            String addres = "address=0-59";
            String city = "city=Quetzaltenango";
            String postalCode = "postalCode=45";
            String email="email=jorge.fuentes.14288@gmail.com";
            String languaje="languaje="+1;
            String notifyEmail = "notiryEmail="+true;
            String notifyFlag = "notifyFlag="+true;
            //abrimos la conexiÃ³n
            URLConnection conn = url.openConnection();
            //especificamos que vamos a escribir
            conn.setDoOutput(true);
            conn.set
//escribimos
            try ( //obtenemos el flujo de escritura
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())) {
                //escribimos
                wr.write(firstName);
                wr.write(LastName);
                wr.write(addres);
                wr.write(city);
                wr.write(postalCode);
                wr.write(email);
                wr.write(languaje);
                wr.write(notifyEmail);
                wr.write(notifyFlag);
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
