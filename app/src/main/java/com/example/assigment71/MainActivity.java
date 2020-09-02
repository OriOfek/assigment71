package com.example.assigment71;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //variables delecration
    String expression;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //put values in the variables
        expression = "";
        display = (EditText) findViewById(R.id.disply);
    }

    /*
    This function prints "add".
    input:none
    output:none
    description:
    change the variable "expression" and add the right sign
    */
    public void add(View view) {
        //get the text in the edit text and add to it '+'
        expression = display.getText().toString();
        expression += '+';

        //put the new text in the edit test
        display.setText(expression);

        //put the cursor in the end of the string
        display.setSelection(display.getText().length());
    }

    /*
    This function prints "sub".
    input:none
    output:none
    description:
    change the variable "expression" and add the right sign
    */
    public void sub(View view) {
        //get the text in the edit text and add to it '-'
        expression = display.getText().toString();
        expression += '-';

        //put the new text in the edit test
        display.setText(expression);

        //put the cursor in the end of the string
        display.setSelection(display.getText().length());
    }

    /*
   This function prints "multiply".
   input:none
   output:none
   description:
   change the variable "expression" and add the right sign
   */
    public void multiply(View view) {
        //get the text in the edit text and add to it '*'
        expression = display.getText().toString();
        expression += '*';

        //put the new text in the edit test
        display.setText(expression);

        //put the cursor in the end of the string
        display.setSelection(display.getText().length());
    }

    /*
   This function prints "multiply".
   input:none
   output:none
   description:
   change the variable "expression" and add the right sign
   */
    public void divide(View view) {
        //get the text in the edit text and add to it '/'
        expression = display.getText().toString();
        expression += '/';

        //put the new text in the edit test
        display.setText(expression);

        //put the cursor in the end of the string
        display.setSelection(display.getText().length());
    }

    /*
    This function prints "reset".
    input:none
    output:none
    description:
    reset the variable "expression" reset the content of the edit text
    */
    public void reset(View view) {
        //reset the edit test
        expression = "";

        //reset the content of the edit text
        display.setText("");
    }

    /*
    This function prints "getSummery".
    input:none
    output:none
    description:
    this function the the value of the expression and put it in the edit text
    */
    public void getSummery(View view) {
        // start it with the deafult sign
        char sign = '+';

        //in order to get the summery I need these variables
        String number = "";
        float summery = 0;
        boolean isLegal = true;

        // scan the string and get the summery
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                number += expression.charAt(i);
            } else {
                summery = calculate(summery, sign, number);
                sign = expression.charAt(i);
            }
        }
        if (isLegal) {
            display.setText(String.valueOf(summery));
        }
        else {
            display.setText("ileagel expression");
        }

    }

    public float calculate(float summery, char sign, String number) {
        final char ADD = '+';
        final char SUB = '-';
        final char DIVIDE = '/';
        final char MULTIPLY = '*';

        boolean isLegal = true;

        // check the options
        if (sign == ADD) {
            summery += Float.valueOf(number);
            number = "";
        } else if (sign == SUB) {
            if (!number.equals("")) {
                summery -= Float.valueOf(number);
                number = "";
            }
        } else if (sign == MULTIPLY) {
            summery *= Float.valueOf(number);
            number = "";
        } else if (sign == DIVIDE) {
            if (Float.valueOf(number) == 0) {
                isLegal = false;
            } else {
                summery -= Float.valueOf(number);
                number = "";
            }
        }

    }


}