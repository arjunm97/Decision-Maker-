package com.endlessbay.arjun.nb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class subjects extends AppCompatActivity {
    ListView listView;
    String username;
    ArrayList<String> subject=new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    public void subjectList(){

        ParseQuery<ParseObject> query=new ParseQuery<ParseObject>("Subjects");
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if(e==null){
                    if(objects.size() >0){
                        subject.clear();
                        for(ParseObject object:objects) {

                            subject.add(object.get("subject_name").toString());
                        }
                        Toast.makeText(subjects.this,"working",Toast.LENGTH_SHORT).show();
                        arrayAdapter.notifyDataSetChanged();
                    }


                }else{

                    Toast.makeText(subjects.this,"Something went wrong!Try again later",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        listView=findViewById(R.id.subjects);
        //subjects.add("test");
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,subject);
        subjectList();
        arrayAdapter.notifyDataSetChanged();
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent2=new Intent(getApplicationContext(),sub.class);
                intent2.putExtra("subject",subject.get(i).toString());
                startActivity(intent2);

            }
        });
    }

}
