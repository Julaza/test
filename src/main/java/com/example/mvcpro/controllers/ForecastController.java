package com.example.mvcpro.controllers;

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

        modelAndView.addObject("IndexModel", indexModel);

        return modelAndView;
    }

}
