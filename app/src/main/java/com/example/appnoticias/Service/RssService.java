package com.example.appnoticias.Service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.example.appnoticias.rss.BroadCasterRssReciver;

public class RssService extends Service {

    private final long MINUTE = 60000L;
    private BackgroundWorker bw;

    public RssService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int id){
        Log.d("RAULD","A iniciar a thread");
        bw = new BackgroundWorker();
        bw.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class BackgroundWorker extends Thread{

        @Override
        public void run() {
            Log.d("RAULD", "Finalizando requisição");
            agendarProximoServico();
            stopSelf();
        }
    }

    private void agendarProximoServico() {
        Intent intent = new Intent(this, BroadCasterRssReciver.class);
        PendingIntent intencaoAgendada = PendingIntent.getBroadcast(this,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarme = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarme.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + MINUTE*1,intencaoAgendada);
        Log.d("RAULD","Agendando servico");
    }
}
