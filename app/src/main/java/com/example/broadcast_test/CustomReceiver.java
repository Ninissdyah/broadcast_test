package com.example.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private final static String ACTION_CUSTOM_BROADCAST = "action-custom-broadcast";

//action yang di main tadi akan diterima di class ini

    @Override
    public void onReceive(Context context, Intent intent) {
//        mendapatkan actionnya apa, tipe nya apa
        String intentAction = intent.getAction();

//        nampilin pesan dgn toast
        if(intentAction != null) {
            String toastMessage = "unknown";
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "power connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "power disconnected";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "custom broadcast";
                    break;
            }
//            nampilin toast nya
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }


    }
}