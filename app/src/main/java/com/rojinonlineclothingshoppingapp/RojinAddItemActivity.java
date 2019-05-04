package com.rojinonlineclothingshoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RojinAddItemActivity extends AppCompatActivity {
    private EditText etName, etPrice, etDescription, etImageName;
    private Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rojin_add_item);

        etName=findViewById(R.id.etName);
        etPrice=findViewById(R.id.etPrice);
        etImageName=findViewById(R.id.etImageName);
        etDescription=findViewById(R.id.etDescription);
        btnAddItem=findViewById(R.id.btnAddItem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });


    }
    private void Save(){

        try {
            PrintStream printStream=new PrintStream(openFileOutput("words.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etName.getText().toString());
            printStream.println(etPrice.getText().toString());
            printStream.println(etImageName.getText().toString());
            printStream.println(etDescription.getText().toString());
            Toast.makeText(this,"Saved to"+getFilesDir(),Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Log.d("RojinOnlineClothingapp","Error"+e.toString());
            e.printStackTrace();
        }
    }
}
