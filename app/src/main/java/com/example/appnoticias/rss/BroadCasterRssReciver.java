package com.example.appnoticias.rss;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadCasterRssReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("RAULD","STARTOU O SERVICE");
        context.startService(new Intent(context,GetRss.class));
    }
}
