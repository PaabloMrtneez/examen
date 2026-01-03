package com.examen.myapplication;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {
    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        // Creamos la instancia de la base de datos que se usará en toda la aplicación
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "user-database.db")
                .build();
    }
}
