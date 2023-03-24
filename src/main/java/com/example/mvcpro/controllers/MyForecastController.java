package com.example.mvcpro.controllers;

import com.example.mvcpro.models.*;
import com.example.mvcpro.repositories.ForecastRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class MyForecastController { //dirba su html

    @Autowired
    private ForecastRepository forecastRepository;

    @GetMapping("/my-forecasts")
    public ModelAndView index(@RequestParam(required = false) String cityCode) throws IOException {
        var modelAndView = new ModelAndView("myForecasts");
        var model = forecastRepository.findAll();

        modelAndView.addObject("myForecasts", model);
        return modelAndView;
    }
}
