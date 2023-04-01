package com.example.mvcpro.models;

public class ForecastModel { //kintamuosius laikome .

    public String city;
    public String date;
    public double temperature;



    public ForecastModel(String city, String date, double temperature){
        this.city = city;
        this.date = date;
        this.temperature = temperature;

    }

}
