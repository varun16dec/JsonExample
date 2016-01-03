package com.example.radha.jsonexample;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // new AsyncTaskExample().execute();
        new AsyncTaskForHttps().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public class AsyncTaskForHttps extends  AsyncTask<String ,Void,String>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String...params){
            try{
                HTTPSTesting httpsTesting=new HTTPSTesting();
                httpsTesting.checkCertificate();


            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(String s){


        }
    }



    public class AsyncTaskExample extends AsyncTask<String,Void,String> {
        JSONObject jsonObject;
        final String TAG="AsyncTaskExample";
        final String yourUrl="http://bfe862cb.ngrok.io/test.php";
        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String...params){
            try{
                JSONParserUsingURLConnection jsonParser=new JSONParserUsingURLConnection();
                jsonObject=jsonParser.getJSONFromUrl(yourUrl);
                Log.e(TAG,"Json Object "+" name = "+jsonObject.getString("name"));
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(String s){


        }

    }
}
