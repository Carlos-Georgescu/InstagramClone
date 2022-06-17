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
                .applicationId("rQzldudtTgHHmzUKK3kMFNxJrDE5m6Rv9co66Q56")
                .clientKey("qgWvy0nfPyycCthK8uD0rur2QJrZDPAWpbbxaRC0")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
