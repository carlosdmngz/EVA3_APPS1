package com.example.eva3_14_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVw = findViewById(R.id.txtVw);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute(10, 500);
        //15 --> BANNER_ASYNKTASK
        //16 --> LOAD_IMAGE_ASYNTASK
    }

    class MiClaseAsincrona extends AsyncTask <Integer, String, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVw.append("Iniciando tarea asincrona \n");
        }

        @Override
        protected void onPostExecute(Void aVoid) {//Si interactua con la UI
            super.onPostExecute(aVoid);
            txtVw.append("Fin de la tarea asincrona \n");
        }

        @Override
        protected void onProgressUpdate(String... values) { //Si interactua con la UI
            super.onProgressUpdate(values);
            txtVw.append(values[0]);
        }

        @Override //No se interactua con la UI
        protected Void doInBackground(Integer... integers) { //Equivalente a run() en un thread
            int limite = integers[0], time = integers[1];
            for (int i = 0; i < limite; i++){
                try {
                    Thread.sleep(time);
                    publishProgress("i = " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
    }
}