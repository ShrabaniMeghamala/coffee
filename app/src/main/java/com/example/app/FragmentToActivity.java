package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentToActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_to_activity);

        textView = findViewById(R.id.tv);

        Intent intent=getIntent();
        String s = intent.getStringExtra("key");
        textView.setText(s);
    }
}
