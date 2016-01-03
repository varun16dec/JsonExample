package com.example.radha.jsonexample;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by radha on 1/3/2016.
 */
public class HTTPSTesting {

    public void checkCertificate(){
        HttpsURLConnection connection=null;
        try{
            URL url = new URL("https://beta.magzhub.com/test.php");
            connection= (HttpsURLConnection)url.openConnection();

            /*InputStream in = urlConnection.getInputStream();
            BufferedReader reader =new BufferedReader(new InputStreamReader(in));
            StringBuilder sb=new StringBuilder();
            String line=null;
            while ((line=reader.readLine())!=null){
                sb.append(line+"\n");
            }
            Log.e("HTTPSTesting : ", "Certificate : " + sb.toString());
            */
            connection.setRequestMethod("POST");
           /* c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            */
            connection.connect();
            int status = connection.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    sb.toString();
                    Log.e("HTTPS connection : ","Json String "+ sb.toString());
            }


        }catch(Exception e){

        }
    }


}
