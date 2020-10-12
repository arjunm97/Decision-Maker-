package com.endlessbay.arjun.nb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
//Notice Activity


public class sub extends AppCompatActivity {
    String username;
    String subjectt;
    Button add_note;
    ListView notice;
    ArrayAdapter arrayAdapter;
    ArrayList<String> notess=new ArrayList<String>();


    //Code for menu bar
    public void notice(View view){
        Toast.makeText(this,"Currently in Notice section",Toast.LENGTH_SHORT).show();

    }
    public void chat(View view){
        Intent chaty=new Intent(getApplicationContext(),chat.class);
        chaty.putExtra("subject",subjectt);
        startActivity(chaty);

    }
    public void docs(View view){
        Intent docc=new Intent(getApplicationContext(),docs.class);
        docc.putExtra("subject",subjectt);
        startActivity(docc);
    }
    public void Logout(View view){


    }
    public void notice_add(View view){
        Intent intent2=new Intent(getApplicationContext(),add_notee.class);
        intent2.putExtra("subject",subjectt);
        startActivity(intent2);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent  intent =getIntent();
        subjectt=intent.getStringExtra("subject");
        add_note=findViewById(R.id.add_note);

        notice=findViewById(R.id.notice);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,notess);
        notice.setAdapter(arrayAdapter);
        getNotice();


        //giving privilage to taecher(problem to be fixed)
        if(username=="teacher"){
            add_note.setVisibility(View.VISIBLE);
        }

    }
    public void getNotice(){
        //condition for subject
        notess.clear();
        ParseQuery<ParseObject> query=new ParseQuery<ParseObject>("notes_os");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                   if(objects.size()>0){
                       for(ParseObject object:objects){

                           notess.add(object.get("notes").toString());
                       }
                       arrayAdapter.notifyDataSetChanged();
                   }


                }
            }
        });



    }
}
