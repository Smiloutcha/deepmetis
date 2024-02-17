package com.lakhdharmedakrem.deepmetisinterview.controller;

import com.lakhdharmedakrem.deepmetisinterview.dto.ClientOrderRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.mapper.ClientOrderMapper;
import com.lakhdharmedakrem.deepmetisinterview.model.ClientOrder;
import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.model.Sandwich;
import com.lakhdharmedakrem.deepmetisinterview.model.SandwichOrder;
import com.lakhdharmedakrem.deepmetisinterview.repository.ClientOrderRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.IngredientRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.SandwichOrderRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.SandwichRepository;
import com.lakhdharmedakrem.deepmetisinterview.service.ApplicationUserService;
import com.lakhdharmedakrem.deepmetisinterview.service.OrderService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {


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
    @Autowired
    private ApplicationUserService applicationUserService ;

    @Autowired
    private IngredientRepository ingredientRepository;


    @Test
    public void testProfitForDay() {
        sandwichRepository.deleteAll();
        ingredientRepository.deleteAll();
        var clientOrder = buildAndSaveClientOrder();
        var foundElements = clientOrderRepository.findAll() ;
        System.out.printf("Size is " + foundElements.size());
        assertTrue(foundElements.size() == 2 );
        assertEquals(2600,foundElements.stream().mapToDouble(ClientOrder::getTotalCost).sum());
    }


    @Test
    @Order(1)
    public void testNumberOfSandwichesSoldOn() {
        sandwichRepository.deleteAll();
        ingredientRepository.deleteAll();
        var sandwich = new Sandwich();
        var ingrediant = buildIngrediant("onion","vegetables",100.0,10l);
        var ingrediantTwo = buildIngrediant("Tomato","vegetables",100,5l);
        sandwich.setIngredients(List.of(ingrediant,ingrediantTwo));
        sandwichRepository.save(sandwich);

        var sandwich1 = new Sandwich();
        var ingrediant1 = buildIngrediant("onion1","vegetables",100.0,10l);
        var ingrediantTwo1 = buildIngrediant("Tomato1","vegetables",100,5l);
        sandwich1.setIngredients(List.of(ingrediant1,ingrediantTwo1));
        sandwichRepository.save(sandwich1);


        var result  = applicationUserService.getNumberOfSandwichesSoldOn(LocalDateTime.now());
        assertTrue(result==2);
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
        orderService.placeOrderForSandwiches(clientOrderRequest);
        return clientOrderRequest ;
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
