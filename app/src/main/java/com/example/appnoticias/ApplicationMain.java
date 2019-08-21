package com.example.appnoticias;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import com.example.appnoticias.rss.BroadCasterRssReciver;

public class ApplicationMain extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("RAULD","Iniciando aplicação");
        sendBroadcast(new Intent(this, BroadCasterRssReciver.class));

    }
}
