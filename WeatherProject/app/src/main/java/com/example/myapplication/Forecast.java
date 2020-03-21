package com.example.myapplication;

import java.io.Serializable;
import java.util.List;

public class Forecast implements Serializable {

    private int dt;
    private MainClass main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private System sys;
    private String dt_txt;

    public Forecast(int dt, MainClass main, List<Weather> weather, Clouds clouds, Wind wind, Rain rain, System sys, String dt_txt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public MainClass getMain() {
        return main;
    }

    public void setMain(MainClass main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public System getSys() {
        return sys;
    }

    public void setSys(System sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }


    @Override
    public String toString() {
        return "Prevision{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", rain=" + rain +
                ", sys=" + sys +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }


    public String formatDate() {
        return "<b>" + this.dt_txt.substring(8,10)+ "/" + this.dt_txt.substring(5,7) + "/" +this.dt_txt.substring(0,4) + "</b>&nbsp;&nbsp; Heure : <b>" + this.dt_txt.substring(11,16) + "</b>";
    }
}


