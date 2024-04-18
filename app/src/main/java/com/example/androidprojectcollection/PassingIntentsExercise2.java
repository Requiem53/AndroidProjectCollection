package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        TextView tfFirstName = findViewById(R.id.tfFirstName);
        TextView tfLastName = findViewById(R.id.tfLastName);
        TextView tfGender = findViewById(R.id.tfGender);
        TextView tfBirthDate = findViewById(R.id.tfBirthDate);
        TextView tfPhoneNum = findViewById(R.id.tfPhoneNum);
        TextView tfEmailAddress = findViewById(R.id.tfEmailAddress);
        TextView tfHomeAddress = findViewById(R.id.tfHomeAddress);
        TextView tfFatherName = findViewById(R.id.tfFatherName);
        TextView tfMotherName = findViewById(R.id.tfMotherName);
        TextView tfYearLevel = findViewById(R.id.tfYearLevel);
        TextView tfCourse = findViewById(R.id.tfCourse);

        Intent intent = getIntent();

        String fName = intent.getStringExtra("fname_key");
        String lName = intent.getStringExtra("lname_key");

        String gender = intent.getStringExtra("gender_key");

        String bDate = intent.getStringExtra("bDate_key");
        String phoneNum = intent.getStringExtra("phoneNum_key");
        String emailAdd = intent.getStringExtra("emailAdd_key");
        String homeAdd = intent.getStringExtra("homeAdd_key");
        String fatherName = intent.getStringExtra("fatherName_key");
        String motherName = intent.getStringExtra("motherName_key");

        String yearLevel = intent.getStringExtra("yearLevel_key");

        String course = intent.getStringExtra("course_key");

        tfFirstName.setText(fName);
        tfLastName.setText(lName);
        tfGender.setText(gender);
        tfBirthDate.setText(bDate);
        tfPhoneNum.setText(phoneNum);
        tfEmailAddress.setText(emailAdd);
        tfHomeAddress.setText(homeAdd);
        tfFatherName.setText(fatherName);
        tfMotherName.setText(motherName);
        tfYearLevel.setText(yearLevel);
        tfCourse.setText(course);

        Button btnReturn = findViewById(R.id.btnReturnForm);

        btnReturn.setOnClickListener(view -> {
            finish();
        });
    }
}