package com.example.jokesandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokerActivity extends AppCompatActivity {
    public static final String JOKE = "joke" ;

    public static Intent JokeIntent (Context context , String joke){
    Intent intent = new Intent(context,JokerActivity.class);
        intent.putExtra(JOKE,joke) ;
        return intent ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);
        String joke = getIntent().getStringExtra(JOKE);
        if(joke == null) {
            joke = "No jokes today :( " ;

            TextView Joke = (TextView) findViewById(R.id.joke);
            Joke.setText(joke);

        }
    }
}
