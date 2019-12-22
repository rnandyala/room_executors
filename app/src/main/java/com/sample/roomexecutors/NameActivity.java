package com.sample.roomexecutors;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.companylistsql.REPLY";

    private EditText mEditText;

    private Button mSubmitButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_name);


        setView();

    }

    private void setView() {

        mEditText = findViewById(R.id.mCompanyNames);

        mSubmitButton = findViewById(R.id.mAddCompany);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getCompanyName();
    }

    private void getCompanyName() {

        mSubmitButton.setOnClickListener(

                v -> {

                    String mCompanyDetails = mEditText.getText().toString();
                    Intent replyIntent = new Intent();
                    replyIntent.putExtra(EXTRA_REPLY, mCompanyDetails);
                    setResult(RESULT_OK, replyIntent);
                    finish();
                });
    }
}
