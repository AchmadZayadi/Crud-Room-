package com.firebase.crudwithroom;

import android.app.Application;

import androidx.room.Room;

public class MyApp extends Application {


    public static Constans db;

    @Override
    public void onCreate (){
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),Constans.class,"mahasiswa").allowMainThreadQueries()
                .build();
    }
}
