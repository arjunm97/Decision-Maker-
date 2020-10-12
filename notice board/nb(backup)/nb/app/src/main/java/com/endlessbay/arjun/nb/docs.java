package com.endlessbay.arjun.nb;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
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
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class docs extends AppCompatActivity {
    String subjectt;
    ArrayList<String> urls=new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    ListView docslist;

    //Code for menu bar
    public void notice_doc(View view){
       // Toast.makeText(this,"Currently in Notice section",Toast.LENGTH_SHORT).show();
        Intent notey=new Intent(getApplicationContext(),chat.class);
        notey.putExtra("subject",subjectt);
        startActivity(notey);

    }
    public void chat_doc(View view){
        Intent chaty=new Intent(getApplicationContext(),chat.class);
        chaty.putExtra("subject",subjectt);
        startActivity(chaty);

    }
    public void docs_doc(View view){

        Toast.makeText(this,"Currently in Docs Section",Toast.LENGTH_SHORT).show();

    }
    public void Logout(View view){


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docs);
        Intent intent=getIntent();
        subjectt=intent.getStringExtra("subject");

    }

    public void getDocuments(View view){
        Intent sam=new Intent(getApplicationContext(),ViewerDocs.class);
        sam.putExtra("subject",subjectt);
        startActivity(sam);
    }

}
