package com.example.eva3_18_services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Thread hilo;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("SERVICIO","onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("SERVICIO","onStart");
        hilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true) {
                    try {
                        Thread.sleep(1000);
                        Log.wtf("SERVICIO", "trabajo en segundo plano");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        hilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("SERVICIO","onDestroy");
        hilo.interrupt();
    }
}