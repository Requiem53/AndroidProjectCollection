package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PassingIntentsExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        TextView inFirstName = findViewById(R.id.inFirstName);
        TextView inLastName = findViewById(R.id.inLastName);
        RadioGroup rgGender = findViewById(R.id.rgGender);
        TextView inBirthDate = findViewById(R.id.inBirthDate);
        TextView inPhoneNumber = findViewById(R.id.inPhoneNumber);
        TextView inEmailAddress = findViewById(R.id.inEmailAddress);
        TextView inHomeAddress = findViewById(R.id.inHomeAddress);
        TextView inFatherName = findViewById(R.id.inFatherName);
        TextView inMotherName = findViewById(R.id.inMotherName);
        RadioGroup rgYearLevel = findViewById(R.id.rgYearLevel);
        RadioGroup rgCourse = findViewById(R.id.rgCourse);

        RadioButton rbMale = findViewById(R.id.rbMale);
        RadioButton rbFemale = findViewById(R.id.rbFemale);
        RadioButton rbOther = findViewById(R.id.rbOther);
        RadioButton rbUnspecified = findViewById(R.id.rbUnspecified);

        RadioButton rbFirstYear = findViewById(R.id.rbFirstYear);
        RadioButton rbSecondYear = findViewById(R.id.rbSecondYear);
        RadioButton rbThirdYear = findViewById(R.id.rbThirdYear);
        RadioButton rbFourthYear = findViewById(R.id.rbFourthYear);
        RadioButton rbFifthYear = findViewById(R.id.rbFifthYear);

        RadioButton rbBSCS = findViewById(R.id.rbBSCS);
        RadioButton rbBSIT = findViewById(R.id.rbBSIT);
        RadioButton rbBSCE = findViewById(R.id.rbBSCE);
        RadioButton rbBMMA = findViewById(R.id.rbBMMA);

        Button btnClear = findViewById(R.id.btnClear);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnClear.setOnClickListener(view -> {
            inFirstName.setText("");
            inLastName.setText("");
            inBirthDate.setText("");
            inEmailAddress.setText("");
            inPhoneNumber.setText("");
            inHomeAddress.setText("");
            inFatherName.setText("");
            inMotherName.setText("");
            rgGender.clearCheck();
            rgYearLevel.clearCheck();
            rgCourse.clearCheck();
        });

        btnSubmit.setOnClickListener(view -> {
            String fName = inFirstName.getText().toString();
            String lName = inLastName.getText().toString();

            String gender;

            if(rbMale.isChecked()){
                gender = "Male";
            }else if(rbFemale.isChecked()){
                gender = "Female";
            }else if(rbOther.isChecked()){
                gender = "Other";
            }else if(rbUnspecified.isChecked()){
                gender = "Unspecified";
            }else{
                gender = "Unspecified";
            }

            String bDate = inBirthDate.getText().toString();
            String phoneNum = inPhoneNumber.getText().toString();
            String emailAdd = inEmailAddress.getText().toString();
            String homeAdd = inHomeAddress.getText().toString();
            String fatherName = inFatherName.getText().toString();
            String motherName = inMotherName.getText().toString();

            String yearLevel;

            if(rbFirstYear.isChecked()){
                yearLevel = "First Year";
            }else if(rbSecondYear.isChecked()){
                yearLevel = "Second Year";
            }else if(rbThirdYear.isChecked()){
                yearLevel = "Third Year";
            }else if(rbFourthYear.isChecked()){
                yearLevel = "Fourth Year";
            }else if(rbFifthYear.isChecked()){
                yearLevel = "Fifth Year";
            }else{
                yearLevel = "Unspecified";
            }

            String course;

            if(rbBSCS.isChecked()){
                course = "Computer Science";
            }else if(rbBSIT.isChecked()){
                course = "Information Technology";
            }else if(rbBSCE.isChecked()){
                course = "Civil Engineering";
            }else if(rbBMMA.isChecked()){
                course = "Multimedia Arts";
            }else{
                course = "Unspecified";
            }

            Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
            intent.putExtra("fname_key", fName);
            intent.putExtra("lname_key", lName);
            intent.putExtra("gender_key", gender);
            intent.putExtra("bDate_key", bDate);
            intent.putExtra("phoneNum_key", phoneNum);
            intent.putExtra("emailAdd_key", emailAdd);
            intent.putExtra("homeAdd_key", homeAdd);
            intent.putExtra("fatherName_key", fatherName);
            intent.putExtra("motherName_key", motherName);
            intent.putExtra("yearLevel_key", yearLevel);
            intent.putExtra("course_key", course);

            inFirstName.setText("");
            inLastName.setText("");
            inBirthDate.setText("");
            inEmailAddress.setText("");
            inPhoneNumber.setText("");
            inHomeAddress.setText("");
            inFatherName.setText("");
            inMotherName.setText("");
            rgGender.clearCheck();
            rgYearLevel.clearCheck();
            rgCourse.clearCheck();

            startActivity(intent);
        });


    }
}