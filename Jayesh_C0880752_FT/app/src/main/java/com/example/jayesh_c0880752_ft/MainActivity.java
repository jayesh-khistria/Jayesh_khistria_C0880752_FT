package com.example.jayesh_c0880752_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    SeekBar seekbar;
    TextView days, amount, totalPayment;
    CheckBox checkBox,checkBox2,checkBox3;
    int value,rate;
    Button btn;


    List<String> categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        seekbar = findViewById(R.id.seekBar);
        days = findViewById(R.id.textView2);
        amount = findViewById(R.id.textView8);
        totalPayment =findViewById(R.id.textView5);
        btn = findViewById(R.id.orderButton);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        spinner.setOnItemSelectedListener(this);
        categories = new ArrayList<>();
        categories.add("Select Car");
        categories.add("BMW");
        categories.add("Audi");
        categories.add("Benz");
        categories.add("Mitsubishi");
        categories.add("Chevrolet");
        categories.add("Toyota");
        categories.add("Mazda");
        categories.add("Honda");
        categories.add("Volkswagen");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("TAG","OnProgressChanged " + progress);
                days.setText(""+ progress);
                value = progress;
                totalPayment.setText("" + (rate * value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        btn.setOnClickListener(view -> {
            Intent intent  = new Intent(MainActivity.this, Summary_Screen.class);
            intent.putExtra("Total Price", totalPayment.getText().toString());
            startActivity(intent);
        });

    }

    @SuppressLint("SetTextI18n")
    public void radioClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        int ageRelatedRate;
        switch (view.getId()){
            case R.id.rb1:
                if (checked){
                    ageRelatedRate = 5;
                    totalPayment.setText(""+ (ageRelatedRate + rate) * value );
                }
                break;

            case R.id.rb2:
                if (checked){
                    ageRelatedRate = 0;
                    totalPayment.setText(""+ (ageRelatedRate + rate) * value);
                }
                break;

            case R.id.rb3:
                if (checked){
                    ageRelatedRate = -10;
                    totalPayment.setText(""+ (ageRelatedRate + rate) * value);
                }
                break;
        }

    }
    public void checkBoxChecked(View view) {
        boolean selected = ((CheckBox) view).isChecked();
        int optionRelatedRate;
        switch (view.getId()) {
            case R.id.checkBox:
                if (selected) {
                    optionRelatedRate = 5;
                    totalPayment.setText("" + (optionRelatedRate + rate) * value);
            }break;
        }
        switch (view.getId()) {
            case R.id.checkBox2:
                if (selected) {
                    optionRelatedRate = 7;
                    totalPayment.setText("" + (optionRelatedRate + rate) * value);
                }break;
        }
        switch (view.getId()) {
            case R.id.checkBox3:
                if (selected) {
                    optionRelatedRate = 10;
                    totalPayment.setText("" + (optionRelatedRate + rate) * value);
                }break;
        }

    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = spinner.getSelectedItem().toString();
        if (item == "Coffee") {
            rate = 75;
            amount.setText("" + rate);
        } else if (item.equals("BMW")) {
            rate = 100;
            amount.setText("" + rate);
        } else if (item == "Audi") {
            rate = 120;
            amount.setText("" + rate);
        } else if (item == "Benz") {
            rate = 150;
            amount.setText("" + rate);
        } else if (item == "Mitsubishi") {
            rate = 170;
            amount.setText("" + rate);
        } else if (item == "Chevrolet") {
            rate = 200;
            amount.setText("" + rate);
        } else if (item == "Toyota") {
            rate = 225;
            amount.setText("" + rate);
        } else if (item == "Mazda") {
            rate = 250;
            amount.setText("" + rate);
        } else if (item == "Honda") {
            rate = 275;
            amount.setText("" + rate);
        } else if (item == "Volkswagen") {
            rate = 300;
            amount.setText("" + rate);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}