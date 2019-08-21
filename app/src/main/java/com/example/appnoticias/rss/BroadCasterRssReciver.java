package com.example.appnoticias.rss;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.example.appnoticias.Service.RssService;

public class BroadCasterRssReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("RAULD","STARTOU O SERVICE");
        context.startService(new Intent(context, RssService.class));
    }
}
