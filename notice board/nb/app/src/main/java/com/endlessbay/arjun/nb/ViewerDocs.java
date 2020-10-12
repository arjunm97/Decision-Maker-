package com.endlessbay.arjun.nb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ViewerDocs extends AppCompatActivity {
    String subject;
    String urlll;

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer_docs);
        Intent intent=getIntent();
        subject=intent.getStringExtra("subject");


        Log.i("subject",subject);

        urlll="https://endlessbay17.wixsite.com/mysite";


       sam();

    }
    public void sammy(){

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlll));
        startActivity(browserIntent);
    }

    public void sam (){
        Log.i("wb","1");
        webview=findViewById(R.id.wb);
        Log.i("wb","2");
        webview.getSettings().setJavaScriptEnabled(true);
        Log.i("wb","3");
       // webview.setWebViewClient();
        webview.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.startsWith("http://")) {
                    view.getContext().startActivity(
                            new Intent(Intent.ACTION_VIEW, Uri.parse(urlll)));
                    return true;
                } else {
                    return false;
                }
            }
        });
        Log.i("wb","4");
        webview.loadUrl(urlll);
        Log.i("wb","5");



    }




    }





