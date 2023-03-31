package com.example.mvcpro.controllers;

import com.example.mvcpro.models.Forecast;
import com.example.mvcpro.models.ForecastModel;
import com.example.mvcpro.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ForecastRestController { // priima plikus duomenis, bet neatvaizduoja jokiu view/html, dirba tik su duomenim
//nk nedaro, bet perduos i duomenu baze

    @Autowired
    private ForecastRepository forecastRepository;
    private ForecastModel forecastModel;

    @PostMapping(value = "/api/forecast", consumes = "application/json") // siusim i serveri ka norim issaugot
    public void index(@RequestBody ForecastModel model) {

        Forecast entity = new Forecast(model.date,
                String.valueOf(model.temperature),
                model.city,
                1);

        forecastRepository.save(entity);
    }

}
