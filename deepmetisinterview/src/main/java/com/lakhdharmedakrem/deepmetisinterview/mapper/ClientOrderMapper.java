package com.lakhdharmedakrem.deepmetisinterview.mapper;

import com.lakhdharmedakrem.deepmetisinterview.dto.ClientOrderRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.model.ClientOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientOrderMapper {

    ClientOrder mapOrderRequestDtoToOrder (ClientOrderRequestDto clientOrderRequestDto);
}
