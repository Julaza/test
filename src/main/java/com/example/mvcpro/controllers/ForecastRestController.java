package com.example.mvcpro.controllers;

import com.example.mvcpro.models.ForecastModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class ForecastRestController { // priima plikus duomenis, bet neatvaizduoja jokiu view/html, dirba tik su duomenim
//nk nedaro, bet perduos i duomenu baze
    @PostMapping (value = "/api/forecast", consumes = "application/json") // siusim i serveri ka norim issaugot
    public void index(@RequestBody ForecastModel model) {


    }
}
