package com.example.eva1_12_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*Clima[] aClimaCd = {
            new Clima(R.drawable.sunny, "Chihuahua", 28, "Despejado con Viento"),
            new Clima(R.drawable.atmospher, "Delicias", 15, "Viento"),
            new Clima(R.drawable.cloudy, "Camargo", 22.3, "Nublado"),
            new Clima(R.drawable.light_rain, "Casas Grandes", 15, "Poca lluvia"),
            new Clima(R.drawable.rainy, "Parral", 11, "Lluvia"),
            new Clima(R.drawable.snow, "Batopilas", -3, "Nieve"),
            new Clima(R.drawable.thunderstorm, "Madera", 24, "Tormenta"),
            new Clima(R.drawable.tornado, "Guerrero", 17, "Vientos poderosos"),
            new Clima(R.drawable.sunny, "Creel", 12, "Despejado"),
            new Clima(R.drawable.light_rain, "Aldama", 13, "Poca lluvia"),
    };*/

    List<Clima> lstCiudad = new ArrayList<>();

    ListView lstVwClima;

    @Override
    protected void onStart() {
        super.onStart();
        lstVwClima = findViewById(R.id.lstVwClima);
        //lstVwClima.setAdapter(new ClimaAdaptador(this, R.layout.mi_lista_clima, aClimaCd));
        ConexionClima cc = new ConexionClima();
        cc.execute("http://api.openweathermap.org/data/2.5/find?lat=28.6&lon=-106&cnt=30&units=metric&appid=12f854d5d63e9c9e9aa8012dbc8bc47c");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class ConexionClima extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            String sUrl = strings[0];
            String sResul = null;

            try {
                URL url = new URL(sUrl);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

                if(httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){

                    InputStreamReader isReader = new InputStreamReader(httpCon.getInputStream());
                    BufferedReader brDatos = new BufferedReader(isReader);
                    sResul = brDatos.readLine();

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResul;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.wtf("CONEXION",s);
        }
    }
}