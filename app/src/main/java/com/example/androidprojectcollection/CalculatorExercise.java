package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

public class CalculatorExercise extends AppCompatActivity {

    MyCalculatorClass calcInstance;

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
    Button calcDelete;

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
        calcDelete = findViewById(R.id.calcDelete);

        typedOutput = findViewById(R.id.factoredOutput);
        finalOutput = findViewById(R.id.typedOutput);

        typedOutput.setText("0");
        finalOutput.setText("0");

        calcInstance = new MyCalculatorClass(typedOutput, finalOutput);

        calc0.setOnClickListener(view -> {
            calcInstance.typeNum('0');
        });

        calc1.setOnClickListener(view -> {
            calcInstance.typeNum('1');
        });

        calc2.setOnClickListener(view -> {
            calcInstance.typeNum('2');
        });

        calc3.setOnClickListener(view -> {
            calcInstance.typeNum('3');
        });

        calc4.setOnClickListener(view -> {
            calcInstance.typeNum('4');
        });

        calc5.setOnClickListener(view -> {
            calcInstance.typeNum('5');
        });

        calc6.setOnClickListener(view -> {
            calcInstance.typeNum('6');
        });

        calc7.setOnClickListener(view -> {
            calcInstance.typeNum('7');
        });

        calc8.setOnClickListener(view -> {
            calcInstance.typeNum('8');
        });

        calc9.setOnClickListener(view -> {
            calcInstance.typeNum('9');
        });

        calcDivide.setOnClickListener(view -> {
            calcInstance.typeOperation('/');
        });

        calcMultiply.setOnClickListener(view -> {
            calcInstance.typeOperation('*');
        });

        calcPlus.setOnClickListener(view -> {
            calcInstance.typeOperation('+');
        });

        calcMinus.setOnClickListener(view -> {
            calcInstance.typeOperation('-');
        });

        calcDelete.setOnClickListener(view -> {
            calcInstance.typeDelete();
        });

        calcDot.setOnClickListener(view -> {
            calcInstance.typeDot();
        });

        calcEquals.setOnClickListener(view -> {
            calcInstance.evaluateMDASExpression();
        });
    }
}