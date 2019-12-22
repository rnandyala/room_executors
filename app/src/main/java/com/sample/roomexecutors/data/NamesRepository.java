package com.sample.roomexecutors.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NamesRepository {

    private CompanyDao mWordDao;
    private LiveData<List<Company>> mAllWords;


    public NamesRepository(Application mApplication) {
        RoomSingletonInstance database = RoomSingletonInstance.getInstance(mApplication);
        mWordDao = database.getCompanyDao();
        mAllWords = mWordDao.getAllNames();

    }

   public  LiveData<List<Company>> getmAllWords() {
        return mAllWords;
    }


    public void insert(final Company mCompany) {
        RoomSingletonInstance.databaseWriteExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        mWordDao.insertName(mCompany);
                    }
                }


        );
    }

}
