package com.example.radha.jsonexample;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by radha on 1/3/2016.
 */
public class JSONParser {
    final String TAG ="JsonParser";
    static InputStream is=null;
    static JSONObject jobj=null;
    static  String json="";
    DefaultHttpClient httpClient;

    public JSONObject getJSONFromUrl(String url){
        try{
            httpClient=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost(url);
            HttpResponse httpResponse=httpClient.execute(httpPost);
            HttpEntity httpEntity=httpResponse.getEntity();
            is=httpEntity.getContent();

        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            BufferedReader reader =new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb=new StringBuilder();
            String line=null;
            while ((line=reader.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            json=sb.toString();
            Log.e(TAG,"json : "+json);
        }catch (Exception e){
          Log.e(TAG, "Error converting result" + e.toString());
        }

        try{
            jobj =new JSONObject(json);
            return jobj;
        }catch (Exception e){
            Log.e(TAG,"Error pasring data "+e.toString());
        }

        return null;
    }
}
