package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {
    Spinner simpleSpinner;
    String[] simpleItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        simpleItems = getResources().getStringArray(R.array.tours);
        simpleSpinner= findViewById(R.id.spinner);
    }
}
