package com.example.calculator.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.R;
import com.seniorglez.calc.ExpressionParser;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

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


    /**
     *  Updates the input field of the calculator or calculates the result of the saved operation.
     *  It depends on what view triggers the method. It also make the device vibrate for 100 milliseconds.
     *
     * @param view The component that triggers this method
     */
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
            case R.id.buttonDot:
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
        }

        v.vibrate(100);
    }

    /**
     * Calculates the result of the operations represented on the input and updates the result view
     * text with that result.
     */
    private void calculateResult() {
        setResult(new ExpressionParser(input).parse() +"");
    }

    /**
     * Updates the input view  text with the input value.
     */
    private void setInput() {
        ((TextView)findViewById(R.id.textViewInput)).setText(input);
    }


    /**
     * Updates the result view text
     * @param s the new text
     */
    private void setResult(String s){
        ((TextView)findViewById(R.id.textViewResult)).setText(s);
    }

    /**
     * Checks if the input ends with an operation
     * @return true if it's ends with an operation and false if it's not.
     */
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
