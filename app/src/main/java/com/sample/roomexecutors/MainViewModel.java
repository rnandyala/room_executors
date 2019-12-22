package com.sample.roomexecutors;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.sample.roomexecutors.data.Company;
import com.sample.roomexecutors.data.NamesRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private NamesRepository mNameRepository;

    private LiveData<List<Company>> mAllWords;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mNameRepository = new NamesRepository(application);
        mAllWords = mNameRepository.getmAllWords();
    }

    LiveData<List<Company>> getmAllWords() {
        return mAllWords;
    }

    public void insert(Company mCompany) {
        mNameRepository.insert(mCompany);
    }

}
