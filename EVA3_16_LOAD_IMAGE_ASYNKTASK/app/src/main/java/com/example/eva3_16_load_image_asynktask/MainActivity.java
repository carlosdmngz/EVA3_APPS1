package com.example.eva3_16_load_image_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwImagen;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwImagen = findViewById(R.id.imgVwBanner);
        MiClaseAsincrona miCa = new MiClaseAsincrona();
        miCa.execute(10,500);
        //15 --> BANNER_ASYNKTASK
        //16 --> LOAD_IMAGE_ASYNKSTASK
    }

    class MiClaseAsincrona extends AsyncTask<Integer,String,Void> {
        @Override
        protected void onPreExecute() { //Si pueden interactuar con la UI
            super.onPreExecute();
        }
        @Override //no se puede interactuar con la ui
        protected Void doInBackground(Integer... integers) { //equivalente a un run() en un Thread
            try {
                bitmap = descargarImagen("https://images.ctfassets.net/hrltx12pl8hq/8MpEm5OxWXiNqLvWzCYpW/24f02cfe391aa8f25845de858982d449/shutterstock_749707636__1__copy.jpg?fit=fill&w=840&h=350");
                Thread.sleep(1000);
                publishProgress(""+bitmap);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            imgVwImagen.setImageBitmap(bitmap);

        }

    }
    private Bitmap descargarImagen(String url){
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}