package com.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
String s="";
String fileContent="";
int g=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Permissions to write
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }

        // some code

        saveTextAsFile("litchi_mission", "new 11111");
    }





    private void saveTextAsFile(String filename, String myText){
        String fileName = filename + ".txt";
        //create file
        File file = new File(getExternalFilesDir("repo"), fileName);
        //write file
        try {
            
            FileInputStream fos = new FileInputStream(file);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fos));
            while ((s = myReader.readLine()) != null) {
                fileContent += s + "\n";
                g+=1;
            }
            Toast.makeText(getApplicationContext(),fileContent, Toast.LENGTH_LONG).show();

            scanFile(getLayoutInflater().getContext(), file, "text");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void scanFile(Context ctxt, File f, String mimeType) {
        MediaScannerConnection.scanFile(ctxt, new String[] {f.getAbsolutePath()}, new String[] {mimeType}, null);
    }
    }

