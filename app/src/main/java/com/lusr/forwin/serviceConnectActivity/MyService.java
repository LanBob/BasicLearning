package com.lusr.forwin.serviceConnectActivity;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {

    public int progress = 0;
    MyBinder myBinder = new MyBinder();

    Intent intent = new Intent("com.lusr.forwin.receiver");

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        progress = 0;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress += 1;

                    Log.d("LusrTAG", "LusrTag service里面更新值" + progress);

                    intent.putExtra("data",progress + "");
                    sendBroadcast(intent);
                }
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("LusrTAG", "LusrTag 绑定");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public int getProgres() {
        return progress;
    }

    class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}
