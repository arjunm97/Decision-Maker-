package com.endlessbay.arjun.nb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class editChat extends AppCompatActivity {
    EditText editText;
    String subjectt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_chat);
        editText=findViewById(R.id.editText);
        Intent intent=getIntent();
        subjectt=intent.getStringExtra("subject");

    }
    public void submitt(View view){
        //Checking for subject

        ParseObject chaty=new ParseObject("Chat_os");
        chaty.put("chat",editText.getText().toString());
        chaty.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                   Intent intt=new Intent(getApplicationContext(),chat.class);
                   startActivity(intt);
                }
            }
        });
    }
}
