package com.example.broadcast_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CustomReceiver mReceiver = new CustomReceiver();

    private final static String ACTION_CUSTOM_BROADCAST = "action-custom-broadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter(); //ktk klik bc scr implisit bc akan tampil
//        attach act ke filternya
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        //register variabel yg sudah dibuat
        this.registerReceiver(mReceiver, filter);

//        register yg manual
        registerCustomBroadcast();

//        CARA SEND MANUAL
        findViewById(R.id.send_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBroadcast();
            }
        });
    }

//    method nya
    private void sendBroadcast() {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST); //perpindahan 1act ke act lain
//        send instance local
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }

//    method register manual untuk custom
    private void registerCustomBroadcast() {
        IntentFilter filter = new IntentFilter(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, filter);
    }
}