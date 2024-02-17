package com.lakhdharmedakrem.deepmetisinterview.mapper;

import com.lakhdharmedakrem.deepmetisinterview.dto.IngredientRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    Ingredient mapIngredientRequestDtoToIngredient(IngredientRequestDto ingredientRequestDto);

   Ingredient findByName(String name);
}
