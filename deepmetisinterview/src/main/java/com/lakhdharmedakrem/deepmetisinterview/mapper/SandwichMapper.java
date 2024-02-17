package com.lakhdharmedakrem.deepmetisinterview.mapper;

import com.lakhdharmedakrem.deepmetisinterview.dto.SandwichRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.model.Sandwich;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SandwichMapper {

    Sandwich mapSandwichRequestDtoToSandwich(SandwichRequestDto sandwichRequestDto);
}
