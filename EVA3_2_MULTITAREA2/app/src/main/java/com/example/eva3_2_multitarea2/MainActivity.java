package com.example.eva3_2_multitarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //THREAD --> CLASE PARA CREAR HILOS (JAVA)
        //Clase Thread() --> metodo run es generico
        //Crear propia clase que herede de Thread
        //Crear clase anonima
        //sobreescribir el método run(){}

        Thread miHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i= 0;i<10;i++){
                    try {
                        Thread.sleep(1000); //DETIENE LA EJECUCION DEL HILO ACTUAL
                        Log.wtf("HILO PRINCIPAL"," i = " +  (i+1));
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        miHilo.start(); //iniciamos el hilo de ejecucion
        miHilo2 miHilo2 = new miHilo2();
        //miHilo2.run();
        miHilo2.start();


    }
}

class miHilo2 extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i= 0;i<10;i++){
            try {
                Thread.sleep(1000); //DETIENE LA EJECUCION DEL HILO ACTUAL
                Log.wtf("HILO miHilo2"," x = " +  (i+1));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}