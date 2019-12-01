package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {
    List<MyContact> contacts;
    ListView listView;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        contacts = new ArrayList<>();
        listView = findViewById(R.id.listView);
        prepareData();
        refreshDisplay();
    }

    private void prepareData() {
        addFakeContact(8);
        contacts.add(new MyContact("Ali Alizade", "09123456789", R.drawable.profile1));
        contacts.add(new MyContact("Hasan Hasani", "09223456789", R.drawable.profile2));
        contacts.add(new MyContact("Mohammad Fadaei", "09323456789", R.drawable.profile3));
        addFakeContact(7);
        contacts.add(new MyContact("Alireza MOhammadi", "09423456789", R.drawable.profile4));
        addFakeContact(4);
        contacts.add(new MyContact("Erfan Alavi", "09523456789", R.drawable.profile5));
        addFakeContact(8);
        contacts.add(new MyContact("Aziz Isfahani", "09623456789", R.drawable.profile6));
        contacts.add(new MyContact("Kambiz Dadmanesh", "09723456789", R.drawable.profile7));
        contacts.add(new MyContact("Milad Azizi", "09823456789", R.drawable.profile8));
        contacts.add(new MyContact("Naser Abdoli", "09923456789", R.drawable.profile9));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void addFakeContact(int n){
        for (int i = 0; i < n; i++){
            contacts.add(new MyContact("fake contact #" + i, "0912345687" + i, 0));
        }
    }
    private void refreshDisplay() {
        adapter = new ContactAdapter(this, contacts);
        listView.setAdapter(adapter);
    }
}