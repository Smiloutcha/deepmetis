package com.lakhdharmedakrem.deepmetisinterview.controller;

import com.lakhdharmedakrem.deepmetisinterview.dto.ClientOrderRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class ClientOrderController {

    private final OrderService orderService;

    public ClientOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @RequestMapping("/postOrder")
    public ResponseEntity<String> postOrder(ClientOrderRequestDto clientOrderRequestDto) {
        orderService.placeOrderForSandwiches(clientOrderRequestDto);
        return new ResponseEntity<>
                ("You Order has been posted , thank your for using our website", HttpStatus.OK);
    }
}
