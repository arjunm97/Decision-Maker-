package com.endlessbay.arjun.nb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    public void nextActivity(){
        Intent intent=new Intent(getApplicationContext(),subjects.class);
       // intent.putExtra("username",username.getText().toString());
        startActivity(intent);
    }


    public void login(View view){
    ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
        @Override
        public void done(ParseUser user, ParseException e) {
            if(user !=null && e==null){
                Toast.makeText(MainActivity.this,"Login Sucessful",Toast.LENGTH_SHORT).show();
                nextActivity();

            }
            else{
                Toast.makeText(MainActivity.this,"Opps!Something went wrong.Try again later",Toast.LENGTH_SHORT).show();

            }
        }
    });


    }
    public void signUp(View view){
        if(username.getText().toString().equals("")|| password.getText().toString().equals("")){

            Toast.makeText(this,"Username/Password Required",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ParseUser user=new ParseUser();
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){
                        Toast.makeText(MainActivity.this,"Sign Up sucessful",Toast.LENGTH_SHORT).show();
                        nextActivity();

                    }
                    else{
                        Toast.makeText(MainActivity.this,"Something went wrong!Please try again later",Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}
