package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

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
    Button calcDelete;

    TextView typedOutput;
    TextView finalOutput;

    StringBuilder typedText;
    StringBuilder finalText;

    Queue<Double> seqQueueNum = new LinkedList();
    Queue<Character> seqQueueOp = new LinkedList();

    LinkedList<Double> mdasQueueNum = new LinkedList();
    LinkedList<Character> mdasQueueOp = new LinkedList();

    double finalAns = 0;

    boolean decimaled = false;

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

        typedOutput = findViewById(R.id.typedOutput);
        finalOutput = findViewById(R.id.factoredOutput);

        typedOutput.setText("0");
        finalOutput.setText("0");

        typedText = new StringBuilder();
        finalText = new StringBuilder();

        calc0.setOnClickListener(view -> {
            typeNum('0');
        });

        calc1.setOnClickListener(view -> {
           typeNum('1');
        });

        calc2.setOnClickListener(view -> {
            typeNum('2');
        });

        calc3.setOnClickListener(view -> {
            typeNum('3');
        });

        calc4.setOnClickListener(view -> {
            typeNum('4');
        });

        calc5.setOnClickListener(view -> {
            typeNum('5');
        });

        calc6.setOnClickListener(view -> {
            typeNum('6');
        });

        calc7.setOnClickListener(view -> {
            typeNum('7');
        });

        calc8.setOnClickListener(view -> {
            typeNum('8');
        });

        calc9.setOnClickListener(view -> {
            typeNum('9');
        });

        calcDivide.setOnClickListener(view -> {
            typeOperation('/');
        });

        calcMultiply.setOnClickListener(view -> {
            typeOperation('*');
        });

        calcPlus.setOnClickListener(view -> {
            typeOperation('+');
        });

        calcMinus.setOnClickListener(view -> {
            typeOperation('-');
        });

        //Add it so its allowed on a lone number
        calcDot.setOnClickListener(view -> {
            if(typedText.length() == 0){
                typedText.append("0.");
            }else{
                if(typedLast() == '.'){
                    typedText.deleteCharAt(typedText.length()-1);
                    decimaled = false;
                }else if(!decimaled){
                    typedText.append(".");
                    decimaled = true;
                }
            }
            typedOutput.setText(typedText);
        });

        calcEquals.setOnClickListener(view -> {
            for(int i = 0; i < mdasQueueOp.size(); i++){
                if(mdasQueueOp.get(i) == '*' || mdasQueueOp.get(i) == '/'){
                    if(mdasQueueOp.get(i) == '*'){
                        finalAns = mdasQueueNum.remove(i) * mdasQueueNum.remove(i);
                    }else if(mdasQueueOp.get(i) == '/'){
                        finalAns = mdasQueueNum.remove(i) / mdasQueueNum.remove(i);
                    }
                    mdasQueueNum.add(finalAns);
                    mdasQueueOp.remove(i);
                    i--;
                }
            }
            for(int i = 0; i < mdasQueueOp.size(); i++){
                if(mdasQueueOp.get(i) == '+' || mdasQueueOp.get(i) == '-'){
                    if(mdasQueueOp.get(i) == '+'){
                        finalAns = mdasQueueNum.remove(i) + mdasQueueNum.remove(i);
                    }else if(mdasQueueOp.get(i) == '-'){
                        finalAns = mdasQueueNum.remove(i) - mdasQueueNum.remove(i);
                    }
                    mdasQueueNum.add(finalAns);
                    mdasQueueOp.remove(i);
                    i--;
                }
            }
            finalOutput.setText(finalAns+"");
        });

        calcDelete.setOnClickListener(view -> {
            if(typedText.length() > 0){
                if(typedLast() == '.'){
                    decimaled = false;
                }
                typedText.deleteCharAt(typedText.length()-1);
            }
            typedOutput.setText(typedText);
            evaluateSeqExpression();
        });
    }

    void typeNum(char num){
        if(typedText.length() == 0){
            typedText.append(num);
        } else if(typedText.length() == 1 && typedLast() == '0'){
            typedText.setCharAt(typedText.length()-1, num);
        }else{
            typedText.append(num);
        }
        typedOutput.setText(typedText);
        evaluateSeqExpression();
    }

    void typeOperation(char op){
        if(typedText.length() == 0){
            return;
        }else if(typedLast() == '+' || typedLast() == '-' || typedLast() == '/' || typedLast() == '*'){
            typedText.setCharAt(typedText.length()-1, op);
        }else{
            typedText.append(op);
            decimaled = false;
        }
        typedOutput.setText(typedText);
        evaluateSeqExpression();
    }

    void evaluateSeqExpression(){
        if(typedText.length() <= 0){
            finalOutput.setText("0");
            seqQueueNum.clear();
            return;
        }

        if(typedLast() == '+' || typedLast() == '-' || typedLast() == '/' || typedLast() == '*'){
            return;
        }

        double seqNum = 0;
        double temp = 0;

        int decimalState = 0;

        //bug: double operation ma queue
        for(int i = 0; i < typedText.length(); i++){
            if(Character.isDigit(typedText.charAt(i))){
                if(decimalState > 0){
                    seqNum += Character.digit(typedText.charAt(i), 10) / (Math.pow(10,decimalState));
                    decimalState++;
                }else if(seqNum != 0){
                    seqNum *= 10;
                    seqNum += Character.digit(typedText.charAt(i), 10);
                }else{
                    seqNum = Character.digit(typedText.charAt(i), 10);
                }

                if(i+1 >= typedText.length()){
                    seqQueueNum.add(seqNum);
                }
            } else if(typedText.charAt(i) == '.'){
                decimalState = 1;
            } else{
                decimalState = 0;
                seqQueueNum.add(seqNum);
                seqQueueOp.add(typedText.charAt(i));
                seqNum = 0;
            }
        }

        char opState;
        seqNum = 0;

        mdasQueueNum = new LinkedList<>(seqQueueNum);
        mdasQueueOp = new LinkedList<>(seqQueueOp);

        System.out.println(mdasQueueNum + " " + mdasQueueOp);

        //for sequential eval
        while(!seqQueueNum.isEmpty()){
            if(seqNum == 0){
                seqNum = seqQueueNum.remove();
            }
            if(seqQueueOp.isEmpty())
                break;

            opState = seqQueueOp.remove();

            switch(opState){
                case '+':
                    seqNum += seqQueueNum.remove();
                    break;
                case '-':
                    seqNum -= seqQueueNum.remove();
                    break;
                case '*':
                    seqNum *= seqQueueNum.remove();
                    break;
                case '/':
                    seqNum /= seqQueueNum.remove();
                    break;
            }
        }

        finalOutput.setText(seqNum + "");
        seqQueueNum.clear();
        seqQueueOp.clear();
    }

    char typedLast(){
        return typedText.charAt(typedText.length()-1);
    }
}