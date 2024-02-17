package com.lakhdharmedakrem.deepmetisinterview.service;

import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;

import java.time.LocalDateTime;
import java.util.Map;

public interface ApplicationUserService {

     Map<String, Long> getBestSellingIngredientsOn(LocalDateTime localDateTime);
     int getNumberOfSandwichesSoldOn(LocalDateTime localDateTime);
    double getProfitForDayOn(LocalDateTime localDateTime);

}
