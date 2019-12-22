package com.sample.roomexecutors;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sample.roomexecutors.adapter.CompanyListAdapter;
import com.sample.roomexecutors.data.Company;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final int NAME_ACTIIVTY_CODE = 1;

    private MainViewModel mMainViewModel;
    private RecyclerView mRecyclerview;

    private List<Company> mListOfCompanies;
    private CompanyListAdapter mCompanyList;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == NAME_ACTIIVTY_CODE && resultCode == RESULT_OK) {
            Company mCompanyData = new Company(data.getStringExtra(NameActivity.EXTRA_REPLY));

            mMainViewModel.insert(mCompanyData);


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ViewModelProviders.of(this, factory).get(MyViewModel::class.java)

        setContentView(R.layout.activity_main);
        setUpRecyclerview();
        // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        mMainViewModel.getmAllWords().observe(this, new Observer<List<Company>>() {
            @Override
            public void onChanged(List<Company> companies) {
                mListOfCompanies = companies;
                companies.size();
                mCompanyList.setCompanyList(companies);

            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent i = new Intent(MainActivity.this, NameActivity.class);

                startActivityForResult(i, NAME_ACTIIVTY_CODE);


            }
        });
    }

    private void setUpRecyclerview() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerview = findViewById(R.id.list_of_company);
        mRecyclerview.setLayoutManager(layoutManager);
        mCompanyList = new CompanyListAdapter(mListOfCompanies);
        mRecyclerview.setAdapter(mCompanyList);
    }

}
