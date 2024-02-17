package com.lakhdharmedakrem.deepmetisinterview.service;

import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.model.Sandwich;
import com.lakhdharmedakrem.deepmetisinterview.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional
    @Override
    public Collection<Ingredient> findAvailableIngredients() {
        return ingredientRepository.findAll()
                .stream()
                .filter(ingredient -> ingredient.getAvailableQuantity() > 0)
                .collect(Collectors.toList());
    }




}
