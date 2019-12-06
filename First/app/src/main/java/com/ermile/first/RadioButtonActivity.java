package com.ermile.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radio_group;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_buttin);
        radio_group = findViewById(R.id.radio_group);
//        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton rb = findViewById(radio_group.getCheckedRadioButtonId());
//                rb.setBackgroundResource(R.drawable.rb_a);
//            }
//        });
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn.getId()){
            int radiobtnId =radio_group.getCheckedRadioButtonId();
            RadioButton rb = findViewById(radiobtnId);
            if (rb != null)
            Toast.makeText(this, (String) rb.getTag(), Toast.LENGTH_SHORT).show();
//            rb.setChecked(false);
        }
    }
}
