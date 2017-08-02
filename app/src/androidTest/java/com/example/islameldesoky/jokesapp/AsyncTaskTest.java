package com.example.islameldesoky.jokesapp;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by islam eldesoky on 30/07/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest   {


    @Test
    public void Test(){
            try {
                JokeAsyncTask jokeAsyncTask = new JokeAsyncTask();
                assertTrue(!jokeAsyncTask.execute().get().isEmpty());


            } catch (Exception e){
                fail();
            }
            }


    }
