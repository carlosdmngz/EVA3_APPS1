package com.example.eva3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgVw;
    Thread tBanner;
    int cont = 0;
    //A traves de un handler, interactuar con la UI
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
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
            imgVw.setImageResource(image);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVw = findViewById(R.id.imgVw);
        tBanner = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep(1000);
                        //Solicitar un mensaje
                        Message message = handler.obtainMessage();
                        //Enviar un mensaje
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        tBanner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tBanner.interrupt();
    }
}