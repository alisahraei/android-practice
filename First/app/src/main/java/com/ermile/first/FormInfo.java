package com.ermile.first;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

class FormInfo implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private final Activity activity;
    private LinearLayout layoutForminfo;
    private EditText input_name;
    private EditText input_phone;
    private EditText input_email;
    private CheckBox checkBox;
    private Button submit;
    public FormInfo(Activity activity, int layoutId) {
        this.activity = activity;
        this.layoutForminfo = activity.findViewById(layoutId);
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
        submit.setOnClickListener(this);
        checkBox.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == checkBox.getId()){
            input_phone.setEnabled(isChecked);
        }
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == submit.getId()){
            String email = input_email.getText().toString().trim();
            String phone= input_phone.getText().toString().trim();
            String name = input_name.getText().toString().trim();
            if (isValdINput(name, phone, email)){
                Toast.makeText(activity, "valid input", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra("name" , name);
                if (checkBox.isChecked()){
                    intent.putExtra("phone" , phone);
                }
                intent.putExtra("email" , email);
                activity.startActivity(intent);
            }
        }
    }

    private boolean isValdINput(String name, String phone, String email) {
        if (name.length() <3){
            Toast.makeText(activity, "3 character", Toast.LENGTH_SHORT).show();
            input_name.requestFocus();
            return false;
        }
        if (checkBox.isChecked()){
            if (!phone.isEmpty() && phone.length() != 11 || !phone.startsWith("09")){
                Toast.makeText(activity, "wrong phone", Toast.LENGTH_SHORT).show();
                input_phone.requestFocus();
                return false;
            }
        }
        if (email.lastIndexOf('@') <= 0|| !email.contains(".") ||
                email.lastIndexOf('.') < email.lastIndexOf('@') || email.split("@").length > 2){
            Toast.makeText(activity, "wrong eamil", Toast.LENGTH_SHORT).show();
            input_email.requestFocus();
            return false;
        }
        return true;
    }

}
