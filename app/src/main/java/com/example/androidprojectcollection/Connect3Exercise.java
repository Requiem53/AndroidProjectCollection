package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Connect3Exercise extends AppCompatActivity {

    Button[][] allButtons;
    Integer[][] allStatus;

    Boolean currentPlayer = false;

    TextView currentPlayerText;

    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3_exercise);

        allButtons = new Button[5][5];
        allStatus = new Integer[5][5];

        currentPlayerText = findViewById(R.id.currentPlayer);
        currentPlayerText.setText("Player 1's Turn:");

        resetButton = findViewById(R.id.resetButton);

        for(int row = 0; row < 5; row++){
            for (int col = 0; col < 5; col++){
                String resIDName = "connect" + row + col;
                allButtons[row][col] = findViewById(this.getResources().getIdentifier(resIDName, "id", this.getPackageName()));
                allStatus[row][col] = 0;
            }
        }

        allButtons[0][0].setOnClickListener(view -> {
            dropCoin(0);
        });

        allButtons[0][1].setOnClickListener(view -> {
            dropCoin(1);
        });

        allButtons[0][2].setOnClickListener(view -> {
            dropCoin(2);
        });

        allButtons[0][3].setOnClickListener(view -> {
            dropCoin(3);
        });

        allButtons[0][4].setOnClickListener(view -> {
            dropCoin(4);
        });

        resetButton.setOnClickListener(view -> {
            reset();
        });
    }

    void dropCoin(int position){
        for(int row = 0; row <= 5; row++){
            if(row == 0 && allStatus[row][position] > 0){
                return;
            }

            if(row < 5 && allStatus[row][position] == 0){
                continue;
            }
            allStatus[row-1][position] = currPlayerCoin();
            allButtons[row-1][position].setBackgroundTintList(currCoinColor());

            System.out.println("------------------------------------------------------------");
            for(int i = 0; i < 5; i++){
                System.out.println(Arrays.toString(allStatus[i]));
            }
            System.out.println("------------------------------------------------------------");

            System.out.println("STATUS DIAGONAL BACK: " + checkWinDiagonalBack(currPlayerCoin(), row-1 , position));
            System.out.println("STATUS DIAGONAL FRONT: " + checkWinDiagonalFront(currPlayerCoin(), row-1 , position));
            System.out.println("STATUS HORIZONTAL: " + checkWinHorizontal(currPlayerCoin(), row-1 , position));
            System.out.println("STATUS VERTICAL: " + checkWinVertical(currPlayerCoin(), row-1 , position));
            if(checkWin(currPlayerCoin(), row-1, position)){
                currentPlayerText.setText("Player " + currPlayerCoin() + " won!");
                for(int i = 0; i <  5; i++){
                    allButtons[0][i].setClickable(false);
                }
                return;
            }

            currentPlayer ^= true;
            break;
        }
    }

    ColorStateList currCoinColor(){
        if(currentPlayer){
            currentPlayerText.setText("Player 1's Turn:");
            return getColorStateList(R.color.green);
        }else{
            currentPlayerText.setText("Player 2's Turn:");
            return getColorStateList(R.color.orange);
        }
    }

    int currPlayerCoin(){
        if(currentPlayer){
            return 2;
        }else{
            return 1;
        }
    }

    void reset(){
        for(int row = 0; row < 5; row++){
            for (int col = 0; col < 5; col++){
                allButtons[row][col].setBackgroundTintList(getColorStateList(R.color.white));
                allStatus[row][col] = 0;
                currentPlayer = false;
                currentPlayerText.setText("Player 1's Turn:");
            }
        }
        for(int i = 0; i < 5; i++){
            allButtons[0][i].setClickable(true);
        }
    }

    boolean checkWin(int player, int row, int col){
        if(checkWinHorizontal(player, row, col) >= 3){
            return true;
        }
        if(checkWinVertical(player, row, col) >= 3){
            return true;
        }
        if(checkWinDiagonalFront(player, row, col) >= 3){
            return true;
        }
        if(checkWinDiagonalBack(player, row, col) >= 3){
            return true;
        }
        return false;
    }

    //DIAGONAL BACK
    int checkWinDiagonalBack(int player, int row, int col){
        //MARIE STOPPPP
        return checkWinDiagonalBackLeft(player, row+1, col-1) +  checkWinDiagonalBackRight(player, row-1, col+1) + 1;
    }
    int checkWinDiagonalBackLeft(int player, int row, int col){
        //MARIE STOPPPP
        if(row >= 5 || row < 0 || col >= 5 || col < 0 || player != allStatus[row][col]){
            return 0;
        }
        return checkWinDiagonalBackLeft(player, row+1, col-1) + 1;
    }
    int checkWinDiagonalBackRight(int player, int row, int col){
        //MARIE STOPPPP
        if(row >= 5 || row < 0 || col >= 5 || col < 0 || player != allStatus[row][col]){
            return 0;
        }
        return checkWinDiagonalBackRight(player, row-1, col+1) + 1;
    }

    //DIAGONAL FRONT
    int checkWinDiagonalFront(int player, int row, int col){
        //MARIE STOPPPP
        return checkWinDiagonalFrontLeft(player, row+1, col+1) +  checkWinDiagonalFrontRight(player, row-1, col-1) + 1;
    }
    int checkWinDiagonalFrontLeft(int player, int row, int col){
        //MARIE STOPPPP
        if(row >= 5 || row < 0 || col >= 5 || col < 0 || player != allStatus[row][col]){
            return 0;
        }
        return checkWinDiagonalFrontLeft(player, row+1, col+1) + 1;
    }
    int checkWinDiagonalFrontRight(int player, int row, int col){
        //MARIE STOPPPP
        if(row >= 5 || row < 0 || col >= 5 || col < 0 || player != allStatus[row][col]){
            return 0;
        }
        return checkWinDiagonalFrontRight(player, row-1, col-1) + 1;
    }

    //HORIZONTAL
    int checkWinHorizontal(int player, int row, int col){
        //MARIE STOPPPP
        return checkWinHorizontalLeft(player, row, col-1) +  checkWinHorizontalRight(player, row, col+1) + 1;
    }
    int checkWinHorizontalLeft(int player, int row, int col){
        //MARIE STOPPPP
        if(col >= 5 || col < 0 || player != allStatus[row][col]){
            return 0;
        }
        return checkWinHorizontalLeft(player, row, col-1) + 1;
    }
    int checkWinHorizontalRight(int player, int row, int col){
        //MARIE STOPPPP
        if(col >= 5 || col < 0 || player != allStatus[row][col]){
            return 0;
        }
        return checkWinHorizontalRight(player, row, col+1) + 1;
    }

    //VERTICAL CHECKER
    int checkWinVertical(int player, int row, int col){
        //MARIE STOPPPP
        return checkWinVerticalUp(player, row+1, col) +  checkWinVerticalDown(player, row-1, col) + 1;
    }
    int checkWinVerticalUp(int player, int row, int col){
        //MARIE STOPPPP
        if(row >= 5 || row < 0 || player != allStatus[row][col]){
            return 0;
        }
        return checkWinVerticalUp(player, row+1, col) + 1;
    }
    int checkWinVerticalDown(int player, int row, int col){
        //MARIE STOPPPP
        if(row >= 5 || row < 0 || player != allStatus[row][col]){
            return 0;
        }
        return checkWinVerticalDown(player, row-1, col) + 1;
    }


}