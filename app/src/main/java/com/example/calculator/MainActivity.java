package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
//lo hago de esta manera para poder añadir el listener desde el xml y no desde el propio codigo

    private String input = "";
    private String ans = "";
    private final String OPERATION_SIMBOLS = "/*+^-";
    private String patten = "(?=[\\^*+\\-\\/])|(?<=[\\^*+\\-\\/])";//añadido un caracter de escape para escapar el caracter de escape
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
                input+=button.getText();
                setInput();
                break;
            case R.id.button2:
                input+=button.getText();
                setInput();
                break;
            case R.id.button3:
                input+=button.getText();
                setInput();
                break;
            case R.id.button4:
                input+=button.getText();
                setInput();
                break;
            case R.id.button5:
                input+=button.getText();
                setInput();
                break;
            case R.id.button6:
                input+=button.getText();
                setInput();
                break;
            case R.id.button7:
                input+=button.getText();
                setInput();
                break;
            case R.id.button8:
                input+=button.getText();
                setInput();
                break;
            case R.id.button9:
                input+=button.getText();
                setInput();
                break;
            case R.id.button0:
                input+=button.getText();
                setInput();
                break;
                //operations

            case R.id.buttonDiv:
                if(!endWithOperation()){
                    input+=button.getText();
                    setInput();
                }
                break;
            case R.id.buttonExp:
                if(!endWithOperation()){
                    input+=button.getText();
                    setInput();
                }
                break;
            case R.id.buttonMinus:
                if(!endWithOperation()){
                    input+=button.getText();
                    setInput();
                }
                break;
            case R.id.buttonMult:
                if(!endWithOperation()){
                    input+=button.getText();
                    setInput();
                }
                break;
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


            String[] split = input.split(patten);
            double res = Double.parseDouble(split[0]);
        for (int i = 1; i < split.length-1; i+=2) {

            switch (split[i]){
                case "+":
                    res = res +Double.parseDouble(split[i+1]);
                    break;
                case "-":
                    res = res -Double.parseDouble(split[i+1]);
                    break;
                case "/":
                    res = res/Double.parseDouble(split[i+1]);
                    break;
                case "*":
                    res = res*Double.parseDouble(split[i+1]);
                    break;
                default://^
                    res = (Math.pow(res,Double.parseDouble(split[i+1])));

            }

        }
        setResult(res+"");


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
