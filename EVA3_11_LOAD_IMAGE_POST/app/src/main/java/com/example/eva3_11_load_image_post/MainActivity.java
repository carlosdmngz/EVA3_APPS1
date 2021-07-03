package com.example.eva3_11_load_image_post;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap;
    ImageView imgVw;
    Handler handler = new Handler();
    Runnable background = new Runnable() {
        @Override
        public void run() {
            bitmap = descargarImagen("https://images.ctfassets.net/hrltx12pl8hq/8MpEm5OxWXiNqLvWzCYpW/24f02cfe391aa8f25845de858982d449/shutterstock_749707636__1__copy.jpg?fit=fill&w=840&h=350");
            handler.post(foreground);
        }
    };
    //TRABAJO CON UI
    Runnable foreground = new Runnable() {
        @Override
        public void run() {

            imgVw.setImageBitmap(bitmap);
        }
    };
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVw = findViewById(R.id.imgVw);
        thread = new Thread(background);
        thread.start();

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