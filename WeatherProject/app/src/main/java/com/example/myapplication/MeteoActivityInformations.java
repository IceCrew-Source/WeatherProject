package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class MeteoActivityInformations extends AppCompatActivity {

    private TextView date, temp, weather, windSpeed, temp2, rain, pressure, humidity, nebulosite, aurore, crepuscule;
    private Button button;
    private ImageView img;
    private Date sunrise, sunset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_details);

        initializeUI();

        Forecast p1 = (Forecast) getIntent().getSerializableExtra("meteo");
        Forecasts ps1 = (Forecasts) getIntent().getSerializableExtra("city");

        date.setText(Html.fromHtml("Date: " + p1.formatDate()));

        temp.setTypeface(null, Typeface.BOLD);
        temp.setText(Integer.toString(Math.round(p1.getMain().getTemp()))+"°");
        temp.setTextSize(35);

        weather.setTextSize(25);
        weather.setTypeface(null,Typeface.BOLD);

        windSpeed.setTypeface(null, Typeface.BOLD);
        windSpeed.setText(Double.toString(Math.round(p1.getWind().getSpeed()*3.6)) + " KM/H");
        windSpeed.setTextSize(20);

        temp2.setText(Integer.toString(Math.round(p1.getMain().getTemp()))+"°");
        temp2.setTypeface(null, Typeface.BOLD);
        temp2.setTextSize(20);

        pressure.setTypeface(null, Typeface.BOLD);
        pressure.setText(p1.getMain().getPressure().toString() + " hPa");

        humidity.setText(p1.getMain().getHumidity().toString() + " %");
        humidity.setTypeface(null, Typeface.BOLD);

        rain.setTypeface(null, Typeface.BOLD);

        if(p1.getRain() != null) {
            if(p1.getRain().getOneH() != 0) {
                rain.setText(Float.toString(p1.getRain().getOneH()));
            } else {
                rain.setText(Float.toString(p1.getRain().getThreeH()));
            }
        }

        nebulosite.setTypeface(null, Typeface.BOLD);
        nebulosite.setText(p1.getClouds().getAll() + " %");

        sunrise = new Date((long)ps1.getCity().getSunrise()*1000);

        aurore.setTypeface(null, Typeface.BOLD);
        aurore.setText(sunrise.toString().substring(10,16));

        sunset = new Date((long)ps1.getCity().getSunset()*1000);

        crepuscule.setTypeface(null, Typeface.BOLD);
        crepuscule.setText(sunset.toString().substring(10,16));


        switch (p1.getWeather().get(0).getMain()) {
            case "Rain":
                img.setImageResource(R.drawable.pluie);
                weather.setText("Pluie");
                break;

            case "Clouds":
                img.setImageResource(R.drawable.unnamed);
                weather.setText("Nuageux");
                break;

            case "Thunderstorm":
                img.setImageResource(R.drawable.eclair);
                weather.setText("Tempete");
                break;

            case "Drizzle":
                img.setImageResource(R.drawable.pluie);
                weather.setText("Bruine");
                break;

            case "Snow":
                img.setImageResource(R.drawable.neige);
                weather.setText("Bruine");
                break;

            default:
                img.setImageResource(R.drawable.cielbleu);
                weather.setText("Ensoleilé");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.Events.TITLE, "titre")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "location")
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 10000)
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 50000);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void initializeUI(){
        date = findViewById(R.id.idDate);
        temp = findViewById(R.id.idTemp);
        weather = findViewById(R.id.idWeather);
        img = findViewById(R.id.img);
        windSpeed = findViewById(R.id.idWindSpeed);
        temp2 = findViewById(R.id.idTemp2);
        rain = findViewById(R.id.idRain);
        pressure = findViewById(R.id.idPressure);
        humidity = findViewById(R.id.idHumidity);
        nebulosite = findViewById(R.id.idNebulosite);
        aurore = findViewById(R.id.idAurore);
        crepuscule = findViewById(R.id.idCrepuscule);
        button = findViewById(R.id.button2);
    }
}
