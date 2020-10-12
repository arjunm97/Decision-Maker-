package com.example.user.decisionmaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  void genrate(){

        Random rand=new Random();
         n=rand.nextInt(5)+1;


    }
    public void refresh(View view){
        genrate();


    }

    public void des(View view){

        genrate();
        TextView result=findViewById(R.id.result);
        if (n==1){

            EditText ed1=findViewById(R.id.ed1);
            result.setText(ed1.getText().toString());

        }
        else if (n==2){
            EditText ed2=findViewById(R.id.ed2);
            result.setText(ed2.getText().toString());


        }
        else if(n==3){

            EditText ed3=findViewById(R.id.ed3);
            result.setText(ed3.getText().toString());

        }
        else if(n==4){

            EditText ed4=findViewById(R.id.ed3);
            result.setText(ed4.getText().toString());
        }

        else if(n==5){


            EditText ed5=findViewById(R.id.ed5);
            result.setText(ed5.getText().toString());
        }

    }
}
