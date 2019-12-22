package com.sample.roomexecutors.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Company.class}, version = 1, exportSchema = false)
public abstract class RoomSingletonInstance extends RoomDatabase {


    public abstract CompanyDao getCompanyDao();

    private static volatile RoomSingletonInstance INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static RoomSingletonInstance getInstance(final Context mContext) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(mContext.getApplicationContext(), RoomSingletonInstance.class, "word_database4")
                    .build();
        }
        return INSTANCE;
    }

}
