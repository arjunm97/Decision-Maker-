package com.endlessbay.arjun.nb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class add_notee extends AppCompatActivity {
    String subject;
    EditText note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notee);
        Intent intent=getIntent();
        subject=intent.getStringExtra("subject");
        note=findViewById(R.id.editText3);
    }

    public void submit(View view){
        ParseObject object=new ParseObject("notes_os");
        object.put("notes",note.getText().toString());
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                   Toast.makeText(add_notee.this,"Sucessfully uploaded",Toast.LENGTH_SHORT).show();
                   // goBack();
                    Intent goBack=new Intent(getApplicationContext(),sub.class);
                    goBack.putExtra("subject",subject);
                    startActivity(goBack);

                }
                else{
                    Toast.makeText(add_notee.this,"Please Try Again Later",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
