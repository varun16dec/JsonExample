package com.example.radha.jsonexample;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by radha on 1/3/2016.
 */
public class JSONParserUsingURLConnection {
    final String TAG="URLConnection.java";
    HttpURLConnection c = null;
    String json;
    JSONObject jsonObject;
    public JSONObject getJSONFromUrl(String url) {
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("POST");
           /* c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            */
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    json=sb.toString();
                    Log.e(TAG,"Json String "+ json);
            }

        } catch (MalformedURLException ex) {
            Log.e(TAG," : MalformedURLException");
        } catch (IOException ex) {
            Log.e(TAG, " : IOException");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try{
            jsonObject =new JSONObject(json);
            return jsonObject;
        }catch (Exception e){
            Log.e(TAG, "Error pasring data " + e.toString());
        }

        return null;
    }
}
