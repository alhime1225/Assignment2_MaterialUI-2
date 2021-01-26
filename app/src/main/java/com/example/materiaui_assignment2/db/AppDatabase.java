package com.example.materiaui_assignment2.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.materiaui_assignment2.dao.PersonDao;
import com.example.materiaui_assignment2.model.Person;

//Creating database
@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //Room framework will provide the data
    public abstract PersonDao personDao();

    private static AppDatabase appDB;

    public static AppDatabase getDB(Context context ){

        if(appDB== null){
            appDB = buildDB(context);
        }

        return  appDB;
    }

  private static AppDatabase  buildDB(Context context) {
      return Room.databaseBuilder(context,  AppDatabase.class,"person-db")
                .allowMainThreadQueries().build();
    }

    public static void cleanUp(){
        appDB = null;
    }
}