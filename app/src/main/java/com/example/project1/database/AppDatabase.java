package com.example.project1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project1.PersonBIO.IPersonBIO;
import com.example.project1.entities.Person;


@Database(entities = {Person.class},  version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME= "personprintlist";
    private static final String LOG_TAG = AppDatabase.class.getName();

    private static final Object LOCK = new Object();
    private static AppDatabase sInstance;


    public static AppDatabase getInstance(Context context){
        if(sInstance==null){
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract IPersonBIO iPersonDAO();

}

