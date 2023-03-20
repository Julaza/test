package com.example.mvcpro.controllers;

import com.example.mvcpro.models.ForecastModel;
import com.example.mvcpro.models.IndexModel;
import com.example.mvcpro.models.Place;
import com.example.mvcpro.models.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class ForecastController {
    @GetMapping("/")
    public ModelAndView index() throws IOException {
        var modelAndView = new ModelAndView("index");
        var indexModel = new IndexModel();

        ArrayList<String> cities = getCities();
        indexModel.cities = cities;

        ArrayList<ForecastModel> forecasts = getForecast();
        indexModel.forecasts = forecasts;

        modelAndView.addObject("IndexModel", indexModel);

        return modelAndView;
    }

    private static ArrayList<String> getCities() throws IOException {
        var cities = new ArrayList<String>();

        var json = loadDataJson("https://api.meteo.lt/v1/places");

        ObjectMapper om = new ObjectMapper();
        Place[] places = om.readValue(json, Place[].class);

        for (var place : places) {
            cities.add(place.name);
        }

        return cities;
    }


    private  static ArrayList<ForecastModel> getForecast() throws IOException{
        var forecasts = new ArrayList<ForecastModel>();

        var json = loadDataJson("https://api.meteo.lt/v1/places/vilnius/forecasts/long-term");
        Root obj = createObj(json);

        for (var stamp : obj.forecastTimestamps) {
            var forecast = new ForecastModel(stamp.forecastTimeUtc, stamp.airTemperature);
            forecasts.add(forecast);
        }

        return forecasts;
    }

    private static Root createObj(String json) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Root obj = om.readValue(json, Root.class);
        return obj;
    }


    private static String loadDataJson(String apiUrl) throws IOException{
    URL url = new URL(apiUrl);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();


        String text = "";
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            text += scanner.nextLine();
        }
        scanner.close();
        return text;
    }

}
