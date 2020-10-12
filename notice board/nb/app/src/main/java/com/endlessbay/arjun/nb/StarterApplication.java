package com.endlessbay.arjun.nb;

import android.app.Application;
import android.util.Log;
import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;



public class StarterApplication extends Application{


        @Override
        public void onCreate() {
            super.onCreate();


            Parse.enableLocalDatastore(this);

            // Add your initialization code here
            Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                    .applicationId("d081b0c3fca4dca23bf5377abe0a1ca522bdef06")
                    .clientKey("65b8e8bf6993eb9004ab54dfde9f72ebafa6f81b")
                    .server("http://13.127.31.197:80/parse/")
                    .build()
            );




            ParseUser.enableAutomaticUser();

            ParseACL defaultACL = new ParseACL();
            defaultACL.setPublicReadAccess(true);
            defaultACL.setPublicWriteAccess(true);
            ParseACL.setDefaultACL(defaultACL, true);

        }
    }


