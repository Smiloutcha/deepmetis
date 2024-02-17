package com.lakhdharmedakrem.deepmetisinterview.controller;

import co.elastic.clients.elasticsearch.nodes.Ingest;
import com.lakhdharmedakrem.deepmetisinterview.model.Ingredient;
import com.lakhdharmedakrem.deepmetisinterview.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController (IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @RequestMapping("/findAvailable")
    public ResponseEntity< Collection<Ingredient>> findAvailableIngredients() {
        return new ResponseEntity<>(ingredientService.findAvailableIngredients(), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/saveIngredient")
    public ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient ingredient) {
        return null;
    }
}
