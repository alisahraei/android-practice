package com.ermile.first;

import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Forminfo {
    private Activity activity;
    private LinearLayout layoutForminfo;
    private EditText input_name;
    private EditText input_phone;
    private EditText input_email;
    private CheckBox checkBox;
    private Button submit;
    public Forminfo(Activity activity, int layoutId){
        this.activity = activity;
        layoutForminfo = activity.findViewById(layoutId);
        init();
    }

    private void init() {
        if (layoutForminfo == null){
            return;
        }
        input_name = layoutForminfo.findViewById(R.id.input_name);
        input_email = layoutForminfo.findViewById(R.id.input_email);
        input_phone = layoutForminfo.findViewById(R.id.input_phone);
        checkBox = layoutForminfo.findViewById(R.id.checkBox);
        submit = layoutForminfo.findViewById(R.id.submit);
    }
}
