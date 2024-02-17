package com.lakhdharmedakrem.deepmetisinterview.dto;

import com.lakhdharmedakrem.deepmetisinterview.model.Sandwich;
import com.lakhdharmedakrem.deepmetisinterview.model.SandwichOrder;

import java.util.Collection;

public class ClientOrderRequestDto {

    private Collection<SandwichOrder> sandwichesOrders ;

    public Collection<SandwichOrder> getSandwiches() {
        return sandwichesOrders;
    }

    public void setSandwiches(Collection<SandwichOrder> sandwiches) {
        this.sandwichesOrders = sandwiches;
    }
}
