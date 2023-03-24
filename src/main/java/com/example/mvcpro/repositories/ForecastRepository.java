package com.example.mvcpro.repositories;

import com.example.mvcpro.models.Forecast;
import com.example.mvcpro.models.ForecastModel;
import org.springframework.data.repository.CrudRepository;

public interface ForecastRepository extends CrudRepository<Forecast, Integer> {



}
