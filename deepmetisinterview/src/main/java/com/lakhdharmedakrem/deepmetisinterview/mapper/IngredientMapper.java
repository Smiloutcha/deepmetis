package com.lakhdharmedakrem.deepmetisinterview.mapper;

import com.lakhdharmedakrem.deepmetisinterview.dto.IngredientRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    Ingredient mapIngredientRequestDtoToIngredient(IngredientRequestDto ingredientRequestDto);
}
