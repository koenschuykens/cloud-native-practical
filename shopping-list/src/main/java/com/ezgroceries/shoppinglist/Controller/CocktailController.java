package com.ezgroceries.shoppinglist.Controller;

import com.ezgroceries.shoppinglist.Database.CocktailDBClient;
import com.ezgroceries.shoppinglist.Resources.CocktailResource;
import com.ezgroceries.shoppinglist.Resources.ShoppingListResource;
import com.ezgroceries.shoppinglist.Services.CocktailService;
import com.ezgroceries.shoppinglist.repositories.CocktailEntity;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CocktailController {
    Map<UUID, ShoppingListResource> shoppinglists = new HashMap<UUID,ShoppingListResource>();

    @Autowired private CocktailService cocktailService;

    @Autowired
    private CocktailDBClient cocktailDBClient;

    @GetMapping(value = "/cocktails", produces = "application/json")
    public ResponseEntity<List<CocktailEntity>> get(@RequestParam String search) {
        System.out.println("Part 1");
        return ResponseEntity.ok((cocktailService.readCocktail(search.toString())));
    }

    /* part 2 create cocktails */
    @PostMapping(value = "/addcocktails", consumes = "application/json", produces = "application/json")
    public ResponseEntity <List<CocktailEntity>> create(@RequestBody List<CocktailResource> cocktailResources) throws JsonParseException {
        System.out.println("Part 7");
        List<CocktailEntity> cocktailEntityList = new ArrayList<>();
        CocktailEntity cocktailEntity = new CocktailEntity();
        for (CocktailResource cocktailResource2 : cocktailResources) {
            cocktailResource2.setCocktailId(UUID.randomUUID().toString());
            cocktailEntity.setCocktailId(UUID.randomUUID());
            cocktailEntity.setName(cocktailResource2.getName());
            cocktailEntity.setIngredients(new HashSet<>(cocktailResource2.getIngredients()));
            cocktailEntityList.add(cocktailService.addCocktail(cocktailEntity));
        }
        return new ResponseEntity<>(cocktailEntityList, HttpStatus.CREATED);
    }

}