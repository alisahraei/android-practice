package com.ermile.files;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText inputFilname, inputContent;
    TextView tv;
    Button btnReadFile , btnCreateFile;
    File extDir;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputFilname = findViewById(R.id.edt_filename);
        inputContent = findViewById(R.id.edt_content);
        tv = findViewById(R.id.tv);
        btnReadFile = findViewById(R.id.btn_read_file);
//        btnReadFile.setOnClickListener(this);
        btnCreateFile = findViewById(R.id.btn_create_file);
//        btnCreateFile.setOnClickListener(this);
//        btnReadFile = findViewById(R.id.btn_read_file);
//        btnCreateFile = findViewById(R.id.btn_create_file);
        extDir = Environment.getExternalStorageDirectory();
//        createExternalFile(new File(extDir, "mydir"), "" , "");
          try {
              tv.setText("internal : " + getFilesDir().getCanonicalPath() + "\n");
              tv.append("external : " + Environment.getExternalStorageDirectory().getAbsolutePath());
          } catch (IOException e){
              e.printStackTrace();
          }
//internal
//        File dir = getFilesDir();
//        tv.setText(dir.getAbsolutePath());
    }
//    private void createInternalFile(String filename, byte[] bytes) {
//        try {
//            FileOutputStream fos = openFileOutput(filename , MODE_PRIVATE);
//            fos.write(bytes);
//            fos.close();
//            Toast.makeText(this, "File create", Toast.LENGTH_SHORT).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    public void onClick(View view){
        String filename = inputFilname.getText().toString().trim();
        String content = inputContent.getText().toString().trim();
        if (view.getId() == btnCreateFile.getId()){
            if (filename.isEmpty()){
                inputFilname.setError("wrong filename");
                inputFilname.requestFocus();
                return;
            }
            if (content.isEmpty()){
                inputContent.setError("no content");
                inputContent.requestFocus();
                return;
            }
        File dir = new File(extDir,"mydir");
        createExternalFile(dir, filename, content);
        }

        else if (view.getId() == btnReadFile.getId()){
            if (filename.isEmpty()){
                inputFilname.setError("wrong filename ...");
                inputFilname.requestFocus();
                return;
            }
        }
    }


    private void createExternalFile(File dir, String filename, String content){
        if (!dir.exists()){
            dir.mkdir();
        }
        filename = filename.replace(' ' , '_');
        File f = new File(dir , filename);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(this, "File created", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    Files in internal storage
//    public void onClick(View view) {
//        if (inputFilname.getText().toString().trim().isEmpty()){
//            inputFilname.setError("wrong filename");
//            return;
//        }
//        String filename = inputFilname.getText().toString().trim();
//        if (view.getId() == R.id.btn_read_file){
//            String content = readInternalFile(filename);
//            inputContent.setText(content);
//
//        }else if (view.getId() == R.id.btn_create_file){
//            if (inputContent.getText().toString().isEmpty()){
//                inputContent.setError("no content");
//                return;
//            }
//            String content = inputContent.getText().toString();
//            createInternalFile(filename, content.getBytes());
//
//        }
//    }



//    private String readInternalFile(String filename) {
//        try {
//            FileInputStream fis = openFileInput(filename);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
//            StringBuilder sb = new StringBuilder();
//            String line = "";
//            while ((line = reader.readLine()) != null){
//                sb.append(line);
//                sb.append("\n");
//            }
//            return  sb.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Exception" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//        }
//        return "";
//    }
}
