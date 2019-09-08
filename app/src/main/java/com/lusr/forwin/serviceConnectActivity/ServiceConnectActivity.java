package com.lusr.forwin.serviceConnectActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.lusr.forwin.R;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceConnectActivity extends Activity {

    @BindView(R.id.showText)
    TextView showText;

    MyService.MyBinder myBinder;
    MyService myService;


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("LusrTAG", "LusrTag " + service);
            myBinder = (MyService.MyBinder) service;
            myService = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_connect);
        ButterKnife.bind(this);
        myHandler = new MyHandler(showText);
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        getProgress();
    }

    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }

    private void getProgress() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Log.d("LusrTAG","LusrTag 我不信一直空"  );

                    if (myBinder == null) {
                        continue;
                    }

                    Message message = Message.obtain();
                    Log.d("LusrTAG", "LusrTag " + myBinder);
                    message.obj = myService.getProgres();
                    myHandler.sendMessage(message);

                    Log.d("LusrTAG","LusrTag 更新数据" +message.obj);
                }
            }
        }).start();
    }

    static class MyHandler extends Handler {

        WeakReference<TextView> textViewWeakReference;

        public MyHandler(TextView textView) {
            textViewWeakReference = new WeakReference<>(textView);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            TextView showText = textViewWeakReference.get();
            showText.setText(msg.obj + "");
        }
    }
}
