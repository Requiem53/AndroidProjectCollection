package com.example.androidprojectcollection;

import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

public class MyCalculatorClass {
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

    public MyCalculatorClass(TextView typedOutput, TextView finalOutput) {
        this.typedOutput = typedOutput;
        this.finalOutput = finalOutput;

        typedText = new StringBuilder();
        finalText = new StringBuilder();
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
            decimaled = false;
        }else{
            typedText.append(op);
            decimaled = false;
        }
        typedOutput.setText(typedText);
        evaluateSeqExpression();
    }

    void typeDot(){
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
    }

    void typeDelete(){
        if(typedText.length() == 0){
            typedText.setCharAt(0, '0');
        }
        if(typedText.length() > 0){
            if(typedText.length() == 1){
                typedText.setCharAt(0, '0');
            } else{
                typedText.deleteCharAt(typedText.length()-1);
            }

        }
        evaluateSeqExpression();
        typedOutput.setText(typedText);
    }

    void evaluateSeqExpression(){
        //Does nothing if last char is operation
        if(typedLast() == '+' || typedLast() == '-' || typedLast() == '/' || typedLast() == '*'){
            return;
        }

        //Removes decimal when no preceding decimals
        if(typedLast() == '.'){
            typedText.deleteCharAt(typedText.length()-1);
            typedOutput.setText(typedText);
            decimaled = false;
        }

        double seqNum = 0;
        int decimalState = 0;

        //Convert expression to queue
        //Separates operations and numbers
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

    void evaluateMDASExpression(){
        if(!mdasQueueNum.isEmpty()){
            finalAns = mdasQueueNum.peek();
        }

        //evaluates MD first
        System.out.println("1. " + mdasQueueNum + "<->" + mdasQueueOp);
        for(int i = 0; i < mdasQueueOp.size(); i++){
            if(mdasQueueOp.get(i) == '*' || mdasQueueOp.get(i) == '/'){
                if(mdasQueueOp.get(i) == '*'){
                    finalAns = mdasQueueNum.remove(i) * mdasQueueNum.remove(i);
                }else if(mdasQueueOp.get(i) == '/'){
                    finalAns = mdasQueueNum.remove(i) / mdasQueueNum.remove(i);
                }
                mdasQueueNum.add(i,finalAns);
                mdasQueueOp.remove(i);
                i--;
            }
        }
        //AS
        System.out.println("2. " + mdasQueueNum + "<->" + mdasQueueOp);
        for(int i = 0; i < mdasQueueOp.size(); i++){
            if(mdasQueueOp.get(i) == '+' || mdasQueueOp.get(i) == '-'){
                if(mdasQueueOp.get(i) == '+'){
                    finalAns = mdasQueueNum.remove(i) + mdasQueueNum.remove(i);
                }else if(mdasQueueOp.get(i) == '-'){
                    finalAns = mdasQueueNum.remove(i) - mdasQueueNum.remove(i);
                }
                mdasQueueNum.add(i,finalAns);
                mdasQueueOp.remove(i);
                i--;
            }
        }
        System.out.println("3. " + mdasQueueNum + "<->" + mdasQueueOp);
        finalOutput.setText(finalAns+"");
    }

    char typedLast(){
        return typedText.charAt(typedText.length()-1);
    }
}




//    String typeNum(char num){
//        if(typedText.length() == 0){
//            typedText.append(num);
//        } else if(typedText.length() == 1 && typedLast() == '0'){
//            typedText.setCharAt(typedText.length()-1, num);
//        }else{
//            typedText.append(num);
//        }
//        return typedText.toString();
//    }
//
//    String typeOperation(char op){
//        if(typedText.length() == 0){
//            return "0";
//        }else if(typedLast() == '+' || typedLast() == '-' || typedLast() == '/' || typedLast() == '*'){
//            typedText.setCharAt(typedText.length()-1, op);
//        }else{
//            typedText.append(op);
//            decimaled = false;
//        }
//        evaluateSeqExpression();
//        return typedText.toString();
//    }
//
//    String typeDelete(){
//        if(typedText.length() > 0){
//            if(typedLast() == '.'){
//                typedText.deleteCharAt(typedText.length()-1);
//                decimaled = false;
//            }
//            if(typedText.length() == 1)
//                typedText.setCharAt(0, '0');
//            else
//                typedText.deleteCharAt(typedText.length()-1);
//        }
//        evaluateSeqExpression();
//        return typedText.toString();
//    }
//
//    String typeDot(){
//        if(typedText.length() == 0){
//            typedText.append("0.");
//        }else{
//            if(typedLast() == '.'){
//                typedText.deleteCharAt(typedText.length()-1);
//                decimaled = false;
//            }else if(!decimaled){
//                typedText.append(".");
//                decimaled = true;
//            }
//        }
//        return typedText.toString();
//    }
//
//    String evaluateSeqExpression(){
//        if(typedText.length() <= 0){
//            seqQueueNum.clear();
//            return "0";
//        }
//
//        if(typedLast() == '+' || typedLast() == '-' || typedLast() == '/' || typedLast() == '*'){
//            return typedText.toString();
//        }
//
//        double seqNum = 0;
//        int decimalState = 0;
//
//        //bug: double operation ma queue
//        for(int i = 0; i < typedText.length(); i++){
//            if(Character.isDigit(typedText.charAt(i))){
//                if(decimalState > 0){
//                    seqNum += Character.digit(typedText.charAt(i), 10) / (Math.pow(10,decimalState));
//                    decimalState++;
//                }else if(seqNum != 0){
//                    seqNum *= 10;
//                    seqNum += Character.digit(typedText.charAt(i), 10);
//                }else{
//                    seqNum = Character.digit(typedText.charAt(i), 10);
//                }
//                if(i+1 >= typedText.length()){
//                    seqQueueNum.add(seqNum);
//                }
//            } else if(typedText.charAt(i) == '.'){
//                decimalState = 1;
//            } else{
//                decimalState = 0;
//                seqQueueNum.add(seqNum);
//                seqQueueOp.add(typedText.charAt(i));
//                seqNum = 0;
//            }
//        }
//
//        char opState;
//        seqNum = 0;
//
//        mdasQueueNum = new LinkedList<>(seqQueueNum);
//        mdasQueueOp = new LinkedList<>(seqQueueOp);
//
//        System.out.println(mdasQueueNum + " " + mdasQueueOp);
//
//        //for sequential eval
//        while(!seqQueueNum.isEmpty()){
//            if(seqNum == 0){
//                seqNum = seqQueueNum.remove();
//            }
//            if(seqQueueOp.isEmpty())
//                break;
//
//            opState = seqQueueOp.remove();
//
//            switch(opState){
//                case '+':
//                    seqNum += seqQueueNum.remove();
//                    break;
//                case '-':
//                    seqNum -= seqQueueNum.remove();
//                    break;
//                case '*':
//                    seqNum *= seqQueueNum.remove();
//                    break;
//                case '/':
//                    seqNum /= seqQueueNum.remove();
//                    break;
//            }
//        }
//
//        seqQueueNum.clear();
//        seqQueueOp.clear();
//
//        return seqNum+"";
//    }
