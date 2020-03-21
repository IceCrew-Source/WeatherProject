package com.example.myapplication;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Forecasts implements Serializable {
    private List<Forecast> list;
    private City city;

    public Forecasts(List<Forecast> list, City city) {
        this.list = list;
        this.city = city;
    }

    public List<Forecast> getList() {
        return list;
    }

    public void setList(List<Forecast> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public ArrayList<Forecast> getPrevisionsArrayList(){
        ArrayList<Forecast> forecastList = new ArrayList<>();
        for(Forecast forecast : this.list){
            Forecast w = new Forecast(forecast.getDt(),forecast.getMain(), forecast.getWeather(), forecast.getClouds(), forecast.getWind(), forecast.getRain(), forecast.getSys(), forecast.getDt_txt());
            forecastList.add(w);
        }
        return forecastList;
    }
}
