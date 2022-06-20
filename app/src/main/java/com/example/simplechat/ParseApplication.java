package com.example.simplechat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("sJQfAIn1kSznK3JSyoLZi3Hdd29s8IkftOul9ytE")
                .clientKey("qXiJY85qthzRu8JExcixjAyUNIaQvVoOUX9SigoT")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
