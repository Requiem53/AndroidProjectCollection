package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //she'll be fine on her own
        btn1 = findViewById(R.id.btnLayoutExercise);
        btn1.setOnClickListener(view -> {
            Intent intent1 = new Intent(
                    MainActivity.this, LayoutExercise.class
            );
            startActivity(intent1);
        });

        btn2 = findViewById(R.id.btnButtonExercise);
        btn2.setOnClickListener(view -> {
            Intent intent1 = new Intent(
                    MainActivity.this, ButtonExercise.class
            );
            startActivity(intent1);
        });

        btn3 = findViewById(R.id.btnCalculator);
        btn3.setOnClickListener(view -> {
            Intent intent1 = new Intent(
                    MainActivity.this, CalculatorExercise.class
            );
            startActivity(intent1);
        });
    }
}