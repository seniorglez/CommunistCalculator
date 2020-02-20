package com.example.calculator.model;

public class Calculator {

    private String patten = "(?=[\\^*+\\-\\/])|(?<=[\\^*+\\-\\/])";
    static private Calculator cal = null;


    private Calculator(){
    }

    public static Calculator getCalculatorInstance(){
        if(cal==null) cal= new Calculator();
        return cal;
    }

    public double calculate(String operation) {
        String[] split = operation.split(patten);
        double res = Double.parseDouble(split[0]);
        for (int i = 1; i < split.length - 1; i += 2) {

            switch (split[i]) {
                case "+":
                    res = res + Double.parseDouble(split[i + 1]);
                    break;
                case "-":
                    res = res - Double.parseDouble(split[i + 1]);
                    break;
                case "/":
                    res = res / Double.parseDouble(split[i + 1]);
                    break;
                case "*":
                    res = res * Double.parseDouble(split[i + 1]);
                    break;
                default://^
                    res = (Math.pow(res, Double.parseDouble(split[i + 1])));
            }
        }
        return res;
    }
}
