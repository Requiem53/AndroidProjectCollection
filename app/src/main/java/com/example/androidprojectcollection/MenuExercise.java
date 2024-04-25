package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;
    float scale;
    int currAlpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnChanger);
        scale = this.getResources().getDisplayMetrics().density;
        System.out.println("SCALE: " + scale);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu_exercise, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.mItemChange){
            Toast.makeText(this, "Edit object item is clicked", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.mItemChange1){
            Toast.makeText(this, R.string.change1, Toast.LENGTH_SHORT).show();

            ViewGroup.LayoutParams params = btnChanger.getLayoutParams();
            params.width = ((int) ((50 * scale) + 0.5f));
            params.height = ((int) ((50 * scale) + 0.5f));
            btnChanger.setLayoutParams(params);
        } else if(item.getItemId() == R.id.mItemChange2){
            Toast.makeText(this, R.string.change2, Toast.LENGTH_SHORT).show();

            btnChanger.setBackgroundTintList(getColorStateList(R.color.blue));
        } else if(item.getItemId() == R.id.mItemChange3){
            Toast.makeText(this, R.string.change3, Toast.LENGTH_SHORT).show();

            btnChanger.setBackground(ContextCompat.getDrawable(this, R.drawable.roundshapebutton));
            btnChanger.getBackground().setAlpha(currAlpha);
        } else if(item.getItemId() == R.id.mItemChange4){
            Toast.makeText(this, R.string.change4, Toast.LENGTH_SHORT).show();

            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
            params.horizontalBias = 0.25f;
            params.verticalBias = 0.25f;
            btnChanger.setLayoutParams(params);
        } else if(item.getItemId() == R.id.mItemChange5){
            Toast.makeText(this, R.string.change5, Toast.LENGTH_SHORT).show();
            currAlpha = 64;
            btnChanger.getBackground().setAlpha(currAlpha);
        } else if(item.getItemId() == R.id.mItemReset){
            Toast.makeText(this, "Reset object item is clicked", Toast.LENGTH_SHORT).show();

            ViewGroup.LayoutParams params = btnChanger.getLayoutParams();
            params.width = ((int) ((200 * scale) + 0.5f));
            params.height = ((int) ((200 * scale) + 0.5f));
            btnChanger.setLayoutParams(params);

            btnChanger.setBackgroundTintList(getColorStateList(R.color.gray));

            btnChanger.setBackground(ContextCompat.getDrawable(this, R.drawable.circle_button));

            ConstraintLayout.LayoutParams params2 = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
            params2.horizontalBias = 0.5f;
            params2.verticalBias = 0.5f;
            btnChanger.setLayoutParams(params2);

            currAlpha = 255;
            btnChanger.getBackground().setAlpha(255);
        } else if(item.getItemId() == R.id.mItemExit){
            finish();
        }
            return true;
    }
}