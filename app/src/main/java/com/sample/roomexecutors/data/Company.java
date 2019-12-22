package com.sample.roomexecutors.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "company_of_my_interest")
public class Company {



    @ColumnInfo(name = "mCompanyName")
    private String mWord;


    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int mcompanyId;

    public void setmWord(String mWord) {
        this.mWord = mWord;
    }

    public String getMWord() {
        return mWord;
    }

    public int getMcompanyId() {
        return mcompanyId;
    }

    public void setMcompanyId(int mcompanyId) {
        this.mcompanyId = mcompanyId;
    }

    public Company( String mWord) {

        this.mWord = mWord;
    }


}
