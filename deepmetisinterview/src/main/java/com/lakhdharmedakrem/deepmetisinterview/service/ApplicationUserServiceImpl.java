package com.lakhdharmedakrem.deepmetisinterview.service;

import com.lakhdharmedakrem.deepmetisinterview.model.ClientOrder;
import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.repository.ClientOrderRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.IngredientRepository;
import com.lakhdharmedakrem.deepmetisinterview.repository.SandwichRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private static final String ADMIN = "ADMIN";
    private final IngredientRepository ingredientRepository;
    private final SandwichRepository sandwichRepository ;

    private final ClientOrderRepository clientOrderRepository;

    public ApplicationUserServiceImpl(IngredientRepository ingredientRepository, SandwichRepository sandwichRepository, ClientOrderRepository clientOrderRepository) {
        this.ingredientRepository = ingredientRepository;
        this.sandwichRepository = sandwichRepository ;
        this.clientOrderRepository = clientOrderRepository ;
    }

    @Transactional
    public Map<String, Long> getBestSellingIngredientsOn(LocalDateTime localDateTime) {
        var soldItemsOnGivenDay = ingredientRepository.findByCreationDate(LocalDate.from(localDateTime));
        return soldItemsOnGivenDay.stream()
                .collect(Collectors.groupingBy(Ingredient::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey().reversed())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (oldValue, newValue) -> newValue));
    }

    @Transactional
    public int getNumberOfSandwichesSoldOn(LocalDateTime localDateTime) {
        return sandwichRepository.findByCreationDate(LocalDate.from(localDateTime)).size();
    }

    @Transactional
    public double getProfitForDayOn(LocalDateTime localDateTime) {
        return clientOrderRepository.findByCreationDate(LocalDate.from(localDateTime))
                .stream()
                .mapToDouble(ClientOrder::getTotalCost).sum();
    }




}
