package com.lakhdharmedakrem.deepmetisinterview.service;

import com.lakhdharmedakrem.deepmetisinterview.dto.ClientOrderRequestDto;
import com.lakhdharmedakrem.deepmetisinterview.mapper.ClientOrderMapper;
import com.lakhdharmedakrem.deepmetisinterview.model.ClientOrder;
import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.model.SandwichOrder;
import com.lakhdharmedakrem.deepmetisinterview.repository.ClientOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    private final ClientOrderRepository orderRepository;
    private final ClientOrderMapper orderMapper;

    public OrderServiceImpl(ClientOrderRepository orderRepository, ClientOrderMapper orderMapper) {
        this.orderRepository = orderRepository ;
        this.orderMapper = orderMapper ;
    }


    @Transactional
    @Override
    public void placeOrderForSandwiches(ClientOrderRequestDto orderRequestDto) {
        var order = orderMapper.mapOrderRequestDtoToOrder(orderRequestDto);
        var costOfCurrentOrder = computeOrderPrice(order);
        order.setTotalCost(costOfCurrentOrder);
        orderRepository.save(order);
    }

    private double computeOrderPrice(ClientOrder order) {
        return order.getSandwichesOrders()
                .stream()
                .mapToDouble(this::computeSandwichOrderPrice)
                .sum();
    }

    private double computeSandwichOrderPrice(SandwichOrder sandwichOrder) {
        var singleSandwichPrice =
                sandwichOrder
                        .getSandwich()
                        .getIngredients()
                        .stream()
                        .mapToDouble(Ingredient::getPrice).sum();
        var profitMargin = 0.3 ;
        return (1 + profitMargin) * singleSandwichPrice * sandwichOrder.getQuantity();
    }
}
