package com.lmlunadev.gymapp.listeners;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by Luis on 31/01/2016.
 */
public class NumericInputListener implements InputFilter {

    public enum Type { Integer, Float }

    private final Type dataType;
    private final double minValue;
    private final double maxvalue;
    private int currentValue;

    public NumericInputListener(Type dataType, double minValue, double maxValue){
        this.dataType = dataType;
        this.minValue = minValue;
        this.maxvalue = maxValue;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try
        {
            String firstSegment = dest.toString().substring(0, dstart);
            String secondSegment = dest.toString().substring(dend, dest.length());
            String result = firstSegment + source + secondSegment;

            /*
            Try to parse the new input value to throw an exception if it can't.
            */
            double resultValue;
            if (this.dataType == Type.Integer){
                resultValue = Integer.parseInt(result.toString());
            }
            else {
                resultValue = Float.parseFloat(result.toString());
            }

            /*
            If the input value gets parsed, it should be between
            the limits that were stablished for the listener
            */
            if (resultValue < this.minValue || resultValue > this.maxvalue){
                return "";
            }
        }
        catch (Exception ex){

        }

        return null;
    }

    /*@Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        int parsedValue;
        try{
            if (s.length() > 0) {
                parsedValue = Integer.parseInt(s.toString());
            }else{
                parsedValue = 0;
            }
        }
        catch(Exception ex){
            parsedValue = 0;
        }
        this.currentValue = parsedValue;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        try
        {
            int aaa = 2;
            aaa += 5;
            s = "52555";
            this.
        }
        catch (Exception ex){

        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        try
        {
            int aaa = 2;
            aaa += 5;
        }
        catch (Exception ex){

        }
    }*/
}
