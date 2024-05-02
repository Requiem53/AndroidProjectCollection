package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn9;
    Button btn10;
    Button btn8;

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

        btn4 = findViewById(R.id.btnConnect3);
        btn4.setOnClickListener(view -> {
            Intent intent1 = new Intent(
                    MainActivity.this, Connect3Exercise.class
            );
            startActivity(intent1);
        });

        btn5 = findViewById(R.id.btnPassIntent1);
        btn5.setOnClickListener(view -> {
            Intent intent1 = new Intent(
                    MainActivity.this, PassingIntentsExercise.class
            );
            startActivity(intent1);
        });

        btn6 = findViewById(R.id.btnMenus);
        btn6.setOnClickListener(view -> {
            Intent intent1 = new Intent(
                    MainActivity.this, MenuExercise.class
            );
            startActivity(intent1);
        });

        btn7 = findViewById(R.id.btnMaps);
        btn7.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, MapsExercise.class);
            startActivity(intent1);
        });
    }
}