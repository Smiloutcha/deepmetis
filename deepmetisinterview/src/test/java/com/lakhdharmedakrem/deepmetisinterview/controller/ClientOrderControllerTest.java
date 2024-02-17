package com.lakhdharmedakrem.deepmetisinterview.controller;

import com.lakhdharmedakrem.deepmetisinterview.dto.ClientOrderRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.mapper.ClientOrderMapper;
import com.lakhdharmedakrem.deepmetisinterview.model.ClientOrder;
import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.model.Sandwich;
import com.lakhdharmedakrem.deepmetisinterview.model.SandwichOrder;
import com.lakhdharmedakrem.deepmetisinterview.repository.ClientOrderRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.SandwichOrderRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.SandwichRepository;
import com.lakhdharmedakrem.deepmetisinterview.service.OrderService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientOrderControllerTest {

    @Autowired
    private ClientOrderRepository clientOrderRepository;
    @Autowired
    private ClientOrderController clientOrderController;
    @Autowired
    private SandwichRepository sandwichRepository ;
    @Autowired
    private SandwichOrderRepository sandwichOrderRepository;

    @Autowired
    private ClientOrderMapper clientOrderMapper;

    @Autowired
    private OrderService orderService;


    @Transactional
    @Test
    public void postOrderTest() {
        clientOrderRepository.deleteAll();
        var clientOrderRequet = buildAndSaveClientOrder();
        var saved = orderService.placeOrderForSandwiches(clientOrderRequet);
        var existingElement = clientOrderRepository.findById(saved.getOrderId());
        assertTrue(!existingElement.isEmpty());
        assertEquals(2600.0,existingElement.get().getTotalCost());

    }

    @Transactional
    ClientOrderRequestDto buildAndSaveClientOrder() {
        var clientOrderRequest = new ClientOrderRequestDto() ;
        var sandwich = new Sandwich();
        var ingrediant = buildIngrediant("onion","vegetables",100.0,10l);
        var ingrediantTwo = buildIngrediant("Tomato","vegetables",100,5l);
        sandwich.setIngredients(List.of(ingrediant,ingrediantTwo));
        var sandwichOrder = new SandwichOrder();
        sandwichOrder.setQuantity(10);
        sandwichOrder.setSandwich(sandwich);
        sandwichRepository.save(sandwich);
        var clientOrder = clientOrderMapper.mapOrderRequestDtoToOrder(clientOrderRequest);
        sandwichOrder.setClientOrder(clientOrder);
        clientOrderRequest.setSandwichesOrders(List.of(sandwichOrder));
         clientOrderRepository.save(clientOrder);
         return clientOrderRequest ;
    }


    private static Ingredient buildIngrediant(String name, String ingrediantType,double price , long availableQuantity) {
        var ingrediant = new Ingredient();
        ingrediant.setName(name);
        ingrediant.setIngredientType(ingrediantType);
        ingrediant.setPrice(price);
        ingrediant.setAvailableQuantity(availableQuantity);
        return ingrediant;
    }


}
