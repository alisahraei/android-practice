package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void simpletoast(View view) {
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
//        Toast toast = new Toast(this);

    }

    public void textcolertaost(View view) {
        Toast toast = Toast.makeText(this, "toast color", Toast.LENGTH_SHORT);
        toast.getView().setBackgroundColor(0xfff44436);
        toast.show();
    }

    public void testcolertaost(View view) {
        String tag = (String) view.getTag();
        switch (tag){
            case "alert":
                ColoredToast.alert(this, "this is an alert toast", Toast.LENGTH_SHORT).show();
                break;
            case "warning":
                ColoredToast.warning(this, "this is an warning toast", Toast.LENGTH_SHORT).show();
                break;
            case "info":
                ColoredToast.info(this, "this is an info toast", Toast.LENGTH_SHORT).show();
                break;
            case "success":
                ColoredToast.success(this, "this is an success toast", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void imageToast(View v){
        ColoredToast.imageToast(this, R.drawable.profile9, ColoredToast.LENGTH_SHORT).show();
    }
}
