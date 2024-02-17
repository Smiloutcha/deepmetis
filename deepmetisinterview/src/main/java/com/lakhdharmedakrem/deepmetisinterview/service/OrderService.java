package com.lakhdharmedakrem.deepmetisinterview.service;


import com.lakhdharmedakrem.deepmetisinterview.dto.ClientOrderRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.model.ClientOrder;

public interface OrderService {

    ClientOrder placeOrderForSandwiches(ClientOrderRequestDto clientOrderRequestDto) ;
}
