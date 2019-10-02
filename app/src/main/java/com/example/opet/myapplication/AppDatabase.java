package com.example.opet.myapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by opet on 02/10/2019.
 */

@Database(entities = {Item.class}, version=2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO itemDAO();
    public static AppDatabase INSTANCE;

    public static synchronized AppDatabase getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context,AppDatabase.class,"compra_mercado").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }

        return INSTANCE;
    }
}
