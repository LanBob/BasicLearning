package com.lusr.forwin.serviceConnectActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

public class ServiceConnectActivityBroadcast extends Activity {

    @BindView(R.id.showText)
    TextView showText;
    private MyHandler myHandler;
    Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_connect);
        ButterKnife.bind(this);
        myHandler = new MyHandler(showText);

        receiver = new Receiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.lusr.forwin.receiver");
        registerReceiver(receiver,intentFilter);
        Intent intent = new Intent(this, MyService.class);
        startService(intent);

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }


    class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("LusrTAG", "LusrTag 接收数据" + intent);
            showText.setText(intent.getStringExtra("data"));
        }
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
