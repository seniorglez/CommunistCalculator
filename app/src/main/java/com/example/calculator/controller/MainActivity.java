package com.example.calculator.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.R;
import com.example.calculator.model.Calculator;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
//lo hago de esta manera para poder añadir el listener desde el xml y no desde el propio codigo

    private String input = "";
    private String ans = "";
    private final String OPERATION_SIMBOLS = "/*+^-";
    Vibrator v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v= (Vibrator) getSystemService(VIBRATOR_SERVICE);

    }


    @Override
    public void onClick(View view) {

        Button button = (Button) view;
        switch(view.getId()){
            //numbers
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.button0:
                input+=button.getText();
                setInput();
                break;
                //operations

            case R.id.buttonDiv:
            case R.id.buttonExp:
            case R.id.buttonMinus:
            case R.id.buttonMult:
            case R.id.buttonPlus:
                if(!endWithOperation()){
                    input+=button.getText();
                    setInput();
                }
                break;

            case R.id.buttonEquals:
                if(!endWithOperation()&&input.length()>0){
                    calculateResult();
                }
                break;

            case R.id.buttonDel:
                if(input.length()>0){
                    input=input.substring(0,input.length()-1);
                    setInput();
                }
                break;

            case R.id.buttonDot://añadir doble . //bug aquí
                if(!endWithOperation()){
                    input+=button.getText();
                    setInput();
                }
                break;

        }

        v.vibrate(100);
    }

    private void calculateResult() {
        setResult(Calculator.getCalculatorInstance().calculate(input)  +"");
    }

    private void setInput() {
        ((TextView)findViewById(R.id.textViewInput)).setText(input);
    }

    private void setResult(String s){
        ((TextView)findViewById(R.id.textViewResult)).setText(s);
    }

    private boolean endWithOperation() {
        char[] operations = OPERATION_SIMBOLS.toCharArray();
        for(int i=0; i<operations.length; i++){
            if(input.endsWith(operations[i]+"")){
                return true;
            }
        }
        return false;

    }
}
