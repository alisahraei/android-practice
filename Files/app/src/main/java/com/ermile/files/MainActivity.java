package com.ermile.files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputFilname = findViewById(R.id.edt_filename);
        inputContent = findViewById(R.id.edt_content);
        tv = findViewById(R.id.tv);
//        btnReadFile = findViewById(R.id.btn_read_file);
//        btnCreateFile = findViewById(R.id.btn_create_file);
        File dir = getFilesDir();
        tv.setText(dir.getAbsolutePath());
    }

    public void onClick(View view) {
        if (inputFilname.getText().toString().trim().isEmpty()){
            inputFilname.setError("wrong filename");
            return;
        }
        String filename = inputFilname.getText().toString().trim();
        if (view.getId() == R.id.btn_read_file){
            String content = readInternalFile(filename);
            inputContent.setText(content);

        }else if (view.getId() == R.id.btn_create_file){
            if (inputContent.getText().toString().isEmpty()){
                inputContent.setError("no content");
                return;
            }
            String content = inputContent.getText().toString();
            createInternalFile(filename, content.getBytes());

        }
    }


    private void createInternalFile(String filename, byte[] bytes) {
        try {
            FileOutputStream fos = openFileOutput(filename , MODE_PRIVATE);
            fos.write(bytes);
            fos.close();
            Toast.makeText(this, "File create", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private String readInternalFile(String filename) {
        try {
            FileInputStream fis = openFileInput(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }
            return  sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Exception" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
        return "";
    }
}
