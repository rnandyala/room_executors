package com.sample.roomexecutors.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CompanyDao {

    @Insert
    void insertName(Company mCompany);

    @Query("SELECT * FROM company_of_my_interest ORDER BY mCompanyName ASC")
    LiveData<List<Company>> getAllNames();
}
