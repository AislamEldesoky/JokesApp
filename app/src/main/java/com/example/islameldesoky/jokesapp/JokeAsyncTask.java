package com.example.islameldesoky.jokesapp;

import android.os.AsyncTask;

import com.example.islameldesoky.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


public class JokeAsyncTask extends AsyncTask<Void , Void , String> {
    private static MyApi myApi   =  null ;

    @Override
    protected String doInBackground(Void... params) {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/") // 10.0.2.2 is localhost's IP address in Android emulator
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
         myApi = builder.build();
        String joke = null ;
        try {
            joke = myApi.getJokes().execute().getData() ;
        } catch (IOException e){
            e.printStackTrace();
        }
        return joke  ;
    }
}


