package com.example.eva3_21_broadcastreceiver;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVw;
    Intent inService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVw = findViewById(R.id.txtVw);
        inService = new Intent(this, MyService.class);
        BroadcastReceiver broadcastReceiver = new MiBroadcast();
        IntentFilter intentFilter = new IntentFilter("Mi_Mensaje");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void iniciar(View v){
        startService(inService);
    }

    public void detener(View v){
        stopService(inService);
    }

    class MiBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //Aqui leer los mensajes del servicio
            txtVw.append(intent.getStringExtra("Mensaje") + "\n");
        }
    }
}