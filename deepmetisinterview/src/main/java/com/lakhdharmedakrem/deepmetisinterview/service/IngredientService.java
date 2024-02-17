package com.lakhdharmedakrem.deepmetisinterview.service;

import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;

import java.util.Collection;

public interface IngredientService {

    Collection<Ingredient> findAvailableIngredients();

}
