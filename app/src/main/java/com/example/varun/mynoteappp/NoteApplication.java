package com.example.varun.mynoteappp;

import android.app.Application;

import com.example.varun.mynoteappp.data.NoteDataHelper;

/**
 * Created by varun on 29/9/16.
 */

public class NoteApplication extends Application {

    public void onCreate() {
        NoteDataHelper.getInstance(getApplicationContext());
    }

}
