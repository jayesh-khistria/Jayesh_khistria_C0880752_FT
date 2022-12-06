package com.example.jayesh_c0880752_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Summary_Screen extends AppCompatActivity {

    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_screen);
        resultText =findViewById(R.id.textView11);
        String s1 = getIntent().getStringExtra("Total Price");
        resultText.setText(s1);
    }
}