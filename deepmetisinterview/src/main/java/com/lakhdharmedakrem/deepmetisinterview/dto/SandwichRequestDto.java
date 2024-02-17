package com.lakhdharmedakrem.deepmetisinterview.dto;

import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;

import java.util.Collection;

public class SandwichRequestDto {

    private Collection<IngredientRequestDto> ingredients ;

    public Collection<IngredientRequestDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<IngredientRequestDto> ingredients) {
        this.ingredients = ingredients;
    }
}
