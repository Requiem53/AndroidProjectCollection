package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorExercise extends AppCompatActivity {

    Button calc0;
    Button calc1;
    Button calc2;
    Button calc3;
    Button calc4;
    Button calc5;
    Button calc6;
    Button calc7;
    Button calc8;
    Button calc9;
    Button calcDivide;
    Button calcMultiply;
    Button calcMinus;
    Button calcPlus;
    Button calcDot;
    Button calcEquals;

    TextView typedOutput;
    TextView finalOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);

        calc0 = findViewById(R.id.calc0);
        calc1 = findViewById(R.id.calc1);
        calc2 = findViewById(R.id.calc2);
        calc3 = findViewById(R.id.calc3);
        calc4 = findViewById(R.id.calc4);
        calc5 = findViewById(R.id.calc5);
        calc6 = findViewById(R.id.calc6);
        calc7 = findViewById(R.id.calc7);
        calc8 = findViewById(R.id.calc8);
        calc9 = findViewById(R.id.calc9);
        calcDivide = findViewById(R.id.calcDivide);
        calcMultiply = findViewById(R.id.calcMultiply);
        calcPlus = findViewById(R.id.calcPlus);
        calcMinus = findViewById(R.id.calcMinus);
        calcDot = findViewById(R.id.calcDot);
        calcEquals = findViewById(R.id.calcEquals);

        typedOutput = findViewById(R.id.typedOutput);
        finalOutput = findViewById(R.id.factoredOutput);

        calc0.setOnClickListener(view -> {

        });

        calc1.setOnClickListener(view -> {

        });

        calc2.setOnClickListener(view -> {

        });

        calc3.setOnClickListener(view -> {

        });

        calc4.setOnClickListener(view -> {

        });

        calc5.setOnClickListener(view -> {

        });

        calc6.setOnClickListener(view -> {

        });

        calc7.setOnClickListener(view -> {

        });

        calc8.setOnClickListener(view -> {

        });

        calc9.setOnClickListener(view -> {

        });

        calcDivide.setOnClickListener(view -> {

        });

        calcMultiply.setOnClickListener(view -> {

        });

        calcPlus.setOnClickListener(view -> {

        });

        calcMinus.setOnClickListener(view -> {

        });

        calcDot.setOnClickListener(view -> {

        });

        calcEquals.setOnClickListener(view -> {

        });
    }
}