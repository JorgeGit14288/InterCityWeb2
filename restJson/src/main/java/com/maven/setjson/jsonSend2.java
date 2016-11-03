/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.setjson;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.JSONObject;

/**
 *
 * @author jorge
 */
public class jsonSend2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException, IOException {
        
        
        ///////////////////////////////////////////////////////////////////////////////
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
        
        
        /////////////////////////////////////////////////////////////////////////
        
        
        String userAgent = "Mozilla/5.0 (X11; Linux x86_64; rv:26.0) Gecko/20100101 Firefox/26.0";
        String address = "http://192.168.5.44/app_dev.php/cus/editaccount/";
        String forSending = objJson2.toString();
        String charset = "UTF-8";

        String stringToSend = URLEncoder.encode(forSending, charset);

        URL URL = new URL(address);
        HttpURLConnection connection = (HttpURLConnection)URL.openConnection();
        connection.addRequestProperty("User-Agent", userAgent);

        //Para poder escribir datos a la URL
        connection.setDoOutput(true);

        // Indicamos el tipo de request, POST en este caso
        connection.setRequestMethod("POST");

        // Indicamos un timeout de 10 segundos
        connection.setReadTimeout(10*1000);

        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write("50241109321=" + stringToSend);
        out.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String response;
        while((response = in.readLine()) != null)
            System.out.println(response);
        in.close();
        
        
        
        
        
       /** 
        
        
        // El metodo encode() de URLEncoder se encarga de encodear la cadena que enviaremos
        // al servidor, sustituyendo espacios y caracteres especiales
        String stringToSend = URLEncoder.encode(forSending, charset);

        // 1. Creamos objeto URL
        URL URL = new URL(address);
        // 2. Obtenemos el objeto URLConnection llamando a openConnection() en URL
        URLConnection connection = URL.openConnection();
        // Establecemos algunas propiedas de envió, como es el User-Agent
        connection.addRequestProperty("User-Agent", userAgent);

        // 3. Esto es importantisímo, es aqui donde establecemos la capacidad de envió.
        connection.setDoOutput(true);

        // 4. Abrimos una conexión al recurso para poder escribir/enviar datos al formulario
        // Nota que no se llama explícitamente a connect() porque llamados a getOutputStream()
        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write("50241109321" + stringToSend); // "nombre" es el campo del formulario web
        out.close();

        // Aquí leemos el resultado que nos devolvió el servidor, en efecto, lo que
        // respondió form.php y luego de enviar los datos
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String response;
        while((response = in.readLine()) != null)
            System.out.println(response);
        in.close();
        * 
        * */
    }
    
}
