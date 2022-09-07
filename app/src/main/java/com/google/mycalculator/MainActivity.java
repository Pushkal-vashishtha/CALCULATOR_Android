package com.google.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bplus,bminus,bmul,bdiv,bdot,bequals,be,bper,bAC,b00;
    TextView textView;
    String digits="012345678900.";
    String operators="+-*/%^";
    String deletion="AC";
    String op1,op2,op;
    int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        bplus=findViewById(R.id.bplus);
        bminus=findViewById(R.id.bminus);
        bmul=findViewById(R.id.bmul);
        bdiv=findViewById(R.id.bdiv);
        bequals=findViewById(R.id.bequals);
        bdot=findViewById(R.id.bdot);
        be=findViewById(R.id.be);
        b00=findViewById(R.id.b00);
        bper=findViewById(R.id.bper);
        bAC=findViewById(R.id.bAC);
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bplus.setOnClickListener(this);
        bminus.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bequals.setOnClickListener(this);
        bper.setOnClickListener(this);
        b00.setOnClickListener(this);
        be.setOnClickListener(this);
        bAC.setOnClickListener(this);
        bdot.setOnClickListener(this);

    }
    void calc() {
        float x, y, z;
        x = Float.parseFloat(op1);
        y = Float.parseFloat(op2);
        if (op.equals("+"))
            z = x + y;
        else if (op.equals("-"))
            z = x - y;
        else if (op.equals("*"))
            z = x * y;
        else if (op.equals("%"))
            z = (x / y) * 100;
        else if (op.equals("^")) {
            z = (float) Math.pow(x, y);
        } else {
           z=x/y;
        }
        textView.setText(" " + z);
    }

    @Override
    public void onClick(View view) {
        Button b=(Button) view;
        String text=b.getText().toString();
        if(digits.contains(text)){
            if(k==0) {
                    textView.setText("");
                    k = 1;
            }
            String pre = textView.getText().toString();
            if(!(text.equals(".") && pre.contains(".")))
            textView.setText((pre + text));
        }else if(operators.contains(text)){
            op1=textView.getText().toString();
            op=text;
            k=0;

        }else if(text.equals("=")){
            op2=textView.getText().toString();
            calc();
        }else{
            textView.setText(" ");
        }

    }
}