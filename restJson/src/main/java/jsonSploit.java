
import com.maven.restjson.cData;
import com.maven.restjson.Account;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jorge
 */
public class jsonSploit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gson gson = new Gson();
        System.out.println("OBTENER SOLO UN ARRAY DE CADENA JSON");
        String myURL = "http://192.168.5.44/app_dev.php/cus/getaccount/50241109321.json";
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
        System.out.println(sb.toString());
        System.out.println("\n\n--------------------JSON OBJECT DISPLAY----------------------------\n\n");
        // convertimos el string a json Object
        JSONObject jsonObj = new JSONObject(jsonResult);
        // System.out.println("LA CADENA JSON CONVERTIDA EN OBJETO ES>");
        System.out.println(jsonObj.toString());

        System.out.println("\n\n--------------------- OBTENER ARRAYS DEL OBJETO JSON---------------------------\n\n");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObj);
        gson = new Gson();
        Iterator x = jsonObj.keys();
        while (x.hasNext()) {
            String key = (String) x.next();
            jsonArray.put(jsonObj.get(key));
            System.out.println(key);

        }
        System.out.println("\n\n--------------------- OBTENER ARRAYS DEL OBJETO JSON---------------------------\n\n");
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject) jsonParser.parse(jsonResult);
        JsonArray jsonArr = jo.getAsJsonArray("data");
        Gson googleJson = new Gson();
        ArrayList jsonObjList = googleJson.fromJson(jsonArr, ArrayList.class);
        System.out.println("Listas existentes en data : " + jsonObjList.size());
        System.out.println("los elementos de la lista son  : " + jsonObjList.toString());
        String dataResult = jsonObjList.toString();

        System.out.println("\n\n--------------------- EL OBJETO JSON  ARRAY---------------------------\n\n");
       /// jsonArr.remove(1);
        String elemento1=null;

        Iterator<JsonElement> nombreIterator = jsonArr.iterator();
        JsonElement elemento = null;
        while (nombreIterator.hasNext()) {
             elemento = nombreIterator.next();
            System.out.print(elemento + " \n");
             elemento1 = elemento.toString();
            System.out.println("El elemento 1 es "+ elemento1);
        }
        
       cData data = gson.fromJson(elemento1, cData.class);
      // Account account = gson.fromJson(jo, Account.class);
       if(data.getAccount().getFirst_name()==null)
       {
           System.out.println("Error");
       }
       else
       {
           System.out.print(data.getAccount().getFirst_name());
       }
      // System.out.println(data.acount.getNumber());
        
        

        System.out.println("\n\n--------------------- OBTENEMOS EL OBJETO ACCOUNT---------------------------\n\n");
        //JsonObject jObject = (JsonObject) jsonParser.parse(elemento1);
       // System.out.println(jObject.getAsJsonPrimitive("number"));
        

        
        
    }
}