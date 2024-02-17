package com.lakhdharmedakrem.deepmetisinterview.controller;

import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.repository.IngredientRepository;
import com.lakhdharmedakrem.deepmetisinterview.service.IngredientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class IngrediantsControllerTest {

    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private IngredientRepository ingredientRepository ;


    @Transactional
    @Test
    public void testFindAvailableIngrediants() {
        ingredientRepository.deleteAll();
        var availableIngrediant = buildIngrediant("Onion","Vegetables",100.0,10);
        var nonAvailableIgrediant =  buildIngrediant("Tomato","Vegetables",100.0,0);
        ingredientRepository.saveAll(List.of(availableIngrediant,nonAvailableIgrediant));
        var availableIngrediants = ingredientService.findAvailableIngredients();
        assertTrue(availableIngrediants.size() == 1);
        assertTrue(availableIngrediants.iterator().next().getName().equals(availableIngrediant.getName()));
        assertTrue(!availableIngrediants.contains(nonAvailableIgrediant));
    }

    private static Ingredient buildIngrediant(String name, String ingrediantType, double price , long availableQuantity) {
        var ingrediant = new Ingredient();
        ingrediant.setName(name);
        ingrediant.setIngredientType(ingrediantType);
        ingrediant.setPrice(price);
        ingrediant.setAvailableQuantity(availableQuantity);
        return ingrediant;
    }


}
