package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;


public class ButtonExercise extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        //Toast Components
        CharSequence toastMessage = "5.0 lang ako sir";
        Toast toast = Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT);

        //Set bg of view
        ConstraintLayout currLayout = findViewById(R.id.currLayout);
        AtomicBoolean whiteBG = new AtomicBoolean(true);

        //Set bg of button
        AtomicBoolean whiteButton = new AtomicBoolean(true);

        //1. A button that opens another empty activity that has another button( return button ) that, when clicked, returns to the activity_button_exercise.
        btn1.setOnClickListener(view -> {
            Intent intent1 = new Intent(
                    ButtonExercise.this, ReturnActivity.class
            );
            startActivity(intent1);
        });

        //2. A Toast button. This button creates a Toast object and displays a string message.
        btn2.setOnClickListener(view -> toast.show());

        //3. Change Background. This button changes the background of the activity.
        btn3.setOnClickListener(view -> {
            if(whiteBG.get()){
                currLayout.setBackgroundColor(Color.parseColor("#7b3391"));
                whiteBG.set(false);
            }

            else{
                currLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                whiteBG.set(true);
            }
        });

        //4. Change Button Background. Changes the color of the button when clicked.
        btn4.setOnClickListener(view -> {
            if(whiteButton.get()){
                view.setBackgroundColor(Color.parseColor("#7b3391"));
                whiteButton.set(false);
            }

            else{
                view.setBackgroundColor(Color.parseColor("#FFBB86FC"));
                whiteButton.set(true);
            }
        });

        //5. Disappear. Turns the button invisible.
        btn5.setOnClickListener(view -> btn5.setVisibility(View.GONE));
    }



}