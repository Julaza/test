package com.example.mvcpro.controllers;

import com.example.mvcpro.models.ForecastModel;
import com.example.mvcpro.models.IndexModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
@Controller
public class ForecastController {
    @GetMapping("/")
    public ModelAndView index(){
        var modelAndView = new ModelAndView("index");

        var indexModel = new IndexModel();

        var cities = new ArrayList<String>();
        cities.add("Vilnius");
        cities.add("Kaunas");
        indexModel.cities = cities;
//

        var forecasts = new ArrayList<ForecastModel>();
        forecasts.add(new ForecastModel("2023-02-20" , 1));
        forecasts.add(new ForecastModel("2023-01-01" , 2));
        forecasts.add(new ForecastModel("2023-03-03" , 3));
        indexModel.forecasts = forecasts;
//

        modelAndView.addObject("IndexModel", indexModel);

        return modelAndView;
    }

}
