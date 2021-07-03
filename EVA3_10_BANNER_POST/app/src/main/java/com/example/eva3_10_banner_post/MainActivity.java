package com.example.eva3_10_banner_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Handler handler = new Handler();
    SeekBar skbr;
    int cont = 0, sppd = 1000;


    //Trabajo Pesado, en segundo plano
    Runnable bckgrnd = new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    //Solicitar un mensaje
                    handler.post(frgrnd);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    };

    //Trabajo con la UI
    Runnable frgrnd = new Runnable() {
        @Override
        public void run() {
            //Interactuamos con la UI
            int image;
            if(cont == 0){
                image = R.drawable.f1;
                cont++;
            }else if(cont ==1){
                image = R.drawable.f2;
                cont++;
            }else{
                image = R.drawable.f3;
                cont = 0;
            }
            imageView.setImageResource(image);
        }
    };

    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        skbr = findViewById(R.id.skbr);
        thread = new Thread(bckgrnd);
        thread.start();

        skbr.setMax(900);

        skbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sppd = 1000 - progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}
