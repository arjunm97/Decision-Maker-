package com.endlessbay.arjun.nb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class chat extends AppCompatActivity {
    String username;
    String subjectt;
    ListView chats;
    ArrayList<String> messages=new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    //Code for menu bar
    public void notice_chat(View view){

       //Toast.makeText(this,"working",Toast.LENGTH_SHORT).show();
        Intent inte=new Intent(getApplicationContext(),sub.class);
        inte.putExtra("subject",subjectt);
        Log.i("step","working");
        startActivity(inte);
    }
    public void chat(View view){
        Toast.makeText(this,"Currently in chat room",Toast.LENGTH_SHORT).show();

    }
    public void doc(View view){
        Intent docy=new Intent(getApplicationContext(),docs.class);
        docy.putExtra("subject",subjectt);
        startActivity(docy);

    }
    public void Logout(View view){


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent=getIntent();
        subjectt=intent.getStringExtra("subject");
        chats=findViewById(R.id.chats);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,messages);
        chats.setAdapter(arrayAdapter);
        getChats();
        arrayAdapter.notifyDataSetChanged();
    }
    public void addChat(View view){
        //sending subject and checking which class to update
        Intent intenty=new Intent(getApplicationContext(),editChat.class);
        intenty.putExtra("subject",subjectt);
        startActivity(intenty);
    }
    public void getChats(){
        ParseQuery<ParseObject> query=new ParseQuery<ParseObject>("Chat_os");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){

                        for(ParseObject object:objects){

                            messages.add(object.get("chat").toString());

                        }
                        arrayAdapter.notifyDataSetChanged();
                    }
                    else{

                        Toast.makeText(chat.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

    }

}
