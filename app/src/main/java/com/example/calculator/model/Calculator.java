package com.example.calculator.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String patten = "(?=[\\^*+\\-\\/])|(?<=[\\^*+\\-\\/])";
    static private Calculator cal = null;


    private Calculator(){
    }

    public static Calculator getCalculatorInstance(){
        if(cal==null) cal= new Calculator();
        return cal;
    }

    private String[] findBrackets(String str){
        String regex = "\\((.*?)\\)";//if you try to put a bracket inside a brackets group if will fail
        ArrayList<String>s= new ArrayList<>();
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                s.add(matcher.group(i));//maybe i can just replace the group here calculating the result
            }
        }
        return (String[]) s.toArray();
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
