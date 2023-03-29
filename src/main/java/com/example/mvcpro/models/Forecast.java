package com.example.mvcpro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // modelis, kuris patapts lentele, - reikia entity
public class Forecast {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) // automatiskai didina kas 1 - id
    public Integer id;
    public String date;
    public String temperature;

    public String city;
    public int userId;

    public Forecast(String date, String temperature, String city, int userId){
        this.date = date;
        this.temperature = temperature;
        this.city = city;
        this.userId = userId;
    }
    public Forecast(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
// repository - traukia duomenis is duomenu bazes