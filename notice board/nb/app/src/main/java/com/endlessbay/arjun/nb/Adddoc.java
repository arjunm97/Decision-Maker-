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

public class Adddoc extends AppCompatActivity {
    EditText name;
    EditText uri;
    String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddoc);
        Intent intent=getIntent();
        subject=intent.getStringExtra("subject");
        name=findViewById(R.id.docname);
        uri=findViewById(R.id.urlname);
    }
    public void upload_doc(View view){
        ParseObject object=new ParseObject("Docs");
        object.put("Docname",name.getText().toString());
        object.put("subject",subject);
        object.put("url",uri.getText().toString());

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    Toast.makeText(Adddoc.this,"Sucessfully uploaded",Toast.LENGTH_SHORT).show();
                    Intent samy=new Intent(getApplicationContext(),docs.class);
                    samy.putExtra("subject",subject);
                    startActivity(samy);
                }
            }
        });


    }
}
