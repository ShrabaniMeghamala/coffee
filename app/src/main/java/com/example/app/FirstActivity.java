package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    }
    public void submitSend(View view){
        Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
        intent.putExtra("Name","Meghamal");
        startActivity(intent);
    }

}
