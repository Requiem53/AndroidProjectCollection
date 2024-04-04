package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Connect3Exercise extends AppCompatActivity {

    Button[][] allButtons;
    Boolean[][] allStatus;

    Boolean currentPlayer = false;

    TextView currentPlayerText;

    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3_exercise);

        allButtons = new Button[5][5];
        allStatus = new Boolean[5][5];

        currentPlayerText = findViewById(R.id.currentPlayer);
        currentPlayerText.setText("Player 1's Turn:");

        resetButton = findViewById(R.id.resetButton);

        for(int row = 0; row < 5; row++){
            for (int col = 0; col < 5; col++){
                String resIDName = "connect" + row + col;
                allButtons[row][col] = findViewById(this.getResources().getIdentifier(resIDName, "id", this.getPackageName()));
                allStatus[row][col] = false;
            }
        }

        allButtons[0][0].setOnClickListener(view -> {
            System.out.println("in the real way");
            dropCoin(0);
        });

        allButtons[0][1].setOnClickListener(view -> {
            System.out.println("in the real way");
            dropCoin(1);
        });

        allButtons[0][2].setOnClickListener(view -> {
            System.out.println("in the real way");
            dropCoin(2);
        });

        allButtons[0][3].setOnClickListener(view -> {
            System.out.println("in the real way");
            dropCoin(3);
        });

        allButtons[0][4].setOnClickListener(view -> {
            System.out.println("in the real way");
            dropCoin(4);
        });

        resetButton.setOnClickListener(view -> {
            for(int row = 0; row < 5; row++){
                for (int col = 0; col < 5; col++){
                    allButtons[row][col].setBackgroundTintList(getColorStateList(R.color.white));
                    allStatus[row][col] = false;
                    currentPlayer = true;
                    currentPlayerText.setText("Player 1's Turn:");
                }
            }
        });
    }

    void dropCoin(int position){
        for(int row = 1; row <= 5; row++){
            if(row < 5 && !allStatus[row][position]){
                continue;
            }
            allStatus[row-1][position] = true;
            allButtons[row-1][position].setBackgroundTintList(currCoinColor());
            break;
        }
    }

    ColorStateList currCoinColor(){
        currentPlayer ^= true;
        if(currentPlayer){
            currentPlayerText.setText("Player 1's Turn:");
            return getColorStateList(R.color.green);
        }else{
            currentPlayerText.setText("Player 2's Turn:");
            return getColorStateList(R.color.orange);
        }
    }


}