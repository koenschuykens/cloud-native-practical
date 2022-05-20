package com.ezgroceries.shoppinglist.Controller;

import com.ezgroceries.shoppinglist.Database.CocktailDBClient;
import com.ezgroceries.shoppinglist.Database.CocktailDBResponse;
import com.ezgroceries.shoppinglist.Resources.ShoppingListResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CocktailController {
    Map<UUID, ShoppingListResource> shoppinglists = new HashMap<UUID,ShoppingListResource>();
    /* part 1 get cocktails */
    @Autowired
    private CocktailDBClient cocktailDBClient;

    @GetMapping(value = "/cocktails", produces = "application/json")
    public ResponseEntity<CocktailDBResponse> get(@RequestParam String search) {
        System.out.println("Part 1");
        return ResponseEntity.ok((cocktailDBClient.searchCocktails(search)));
    }

    public static class CocktailId {

        private String cocktailId;

        /* No args constructor */
        public CocktailId() {
        }

        /* All args constructor */
        public CocktailId(String cocktailId) {

            this.cocktailId = cocktailId;

        }

        public String getCocktailId() {
            return cocktailId;
        }

        public void setCocktailId(String cocktailId) {
            this.cocktailId = cocktailId;
        }


    }
}