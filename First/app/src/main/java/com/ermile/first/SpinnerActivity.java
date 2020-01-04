package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
    Spinner simpleSpinner;
    Spinner customSpinner;
    int[] countryFlags = {R.drawable.flag_cn, R.drawable.flag_cz,
            R.drawable.flag_dk, R.drawable.flag_fr, R.drawable.flag_de,
            R.drawable.flag_ir, R.drawable.flag_it, R.drawable.flag_jp,
            R.drawable.flag_kr, R.drawable.flag_pt, R.drawable.flag_pl,
            R.drawable.flag_es, R.drawable.flag_tr};

    String[] countryNames = { "China", "Czech", "Denmark", "France", "Germany",
            "Iran", "Italy", "Japan", "Korea", "Portugal", "Poland", "Spain", "Turkey"};
    String[] simpleItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initSimpleSpinner();
        initCustomSpinner();
    }

    private void initSimpleSpinner() {
        simpleItems = getResources().getStringArray(R.array.tours);
        simpleSpinner= findViewById(R.id.simple_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, simpleItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        simpleSpinner.setAdapter(adapter);
        simpleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this,
                        (String) adapterView.getSelectedItem(),
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void initCustomSpinner() {
        customSpinner = (Spinner) findViewById(R.id.custom_spinner);
        CountrySpinnerAdapter adapter = new CountrySpinnerAdapter(this, countryFlags, countryNames);
        customSpinner.setAdapter(adapter);
        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this,
                        (String) adapterView.getSelectedItem(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
