package com.lusr.forwin.processKeepLive.doubleProcess;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 主进程 双进程通讯
 *
 * @author LiGuangMin
 * @time Created by 2018/8/17 11:26
 */
public class StepService extends Service {

    private final static String TAG = StepService.class.getSimpleName();
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "StepService:建立链接");
//            boolean isServiceRunning = ServiceAliveUtils.isServiceAlice();
//            if (!isServiceRunning) {
//                Intent i = new Intent(StepService.this, DownloadService.class);
//                startService(i);
//            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            // 断开链接
            startService(new Intent(StepService.this, GuardService.class));
            // 重新绑定
            bindService(new Intent(StepService.this, GuardService.class), mServiceConnection, Context.BIND_IMPORTANT);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new DoubleProcessAidl.Stub() {
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(1, new Notification());
        // 绑定建立链接
        bindService(new Intent(this, GuardService.class), mServiceConnection, Context.BIND_IMPORTANT);
        return START_STICKY;
    }

}