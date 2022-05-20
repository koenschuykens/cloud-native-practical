package com.ezgroceries.shoppinglist.Controller;

import com.ezgroceries.shoppinglist.Database.CocktailDBClient;
import com.ezgroceries.shoppinglist.Database.CocktailDBResponse;
import com.ezgroceries.shoppinglist.Resources.CocktailResource;
import com.ezgroceries.shoppinglist.Resources.ShoppingListResource;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ShoppingListController {
    Map<UUID, ShoppingListResource> shoppinglists = new HashMap<UUID,ShoppingListResource>();

    @Autowired
    private CocktailDBClient cocktailDBClient;

    /* part 2 create shopping list */
    @PostMapping(value = "/shopping-lists", consumes = "application/json", produces = "application/json")
    public ResponseEntity <List<ShoppingListResource>> create(@RequestBody List<ShoppingListResource> shoppingListResources) throws JsonParseException {
        System.out.println("Part 2");
        List<ShoppingListResource> shoppingListResourceList = new ArrayList<>();
        for (ShoppingListResource shoppingListResource2 : shoppingListResources) {
                shoppingListResource2.setShoppingListId(UUID.randomUUID());
                shoppinglists.put(shoppingListResource2.getShoppingListId(), shoppingListResource2);
                shoppingListResourceList.add(shoppingListResource2);
        }
        return new ResponseEntity<>(shoppingListResourceList, HttpStatus.CREATED);
    }

    /* Part 3 - add cocktails to list */
    @PostMapping(value = "/shopping-lists/{shoppingListId}/cocktails", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<CocktailController.CocktailId>> create(@PathVariable UUID shoppingListId, @RequestBody List<CocktailResource> cocktailResourceList ) {

        System.out.println("Part 3");

        List<CocktailController.CocktailId> cocktailIdList = new ArrayList<>();
        ShoppingListResource shoppingListResource = shoppinglists.get(shoppingListId);

        for (CocktailResource cocktail:cocktailResourceList){
            CocktailController.CocktailId cocktailId = new CocktailController.CocktailId(cocktail.getCocktailId());
            cocktailIdList.add(cocktailId);
        }
        if (cocktailIdList != null)
        {
            shoppingListResource.setCocktails(cocktailIdList);
            return new ResponseEntity<>(cocktailIdList,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity(HttpStatus.CONFLICT);

        }
    }

    /* Part 4 - get shopping list */
    @GetMapping(value = "/shopping-lists/{shoppingListId}", produces = "application/json")
    public ResponseEntity<ShoppingListOut> get(@PathVariable UUID shoppingListId) {

        System.out.println("Part 4");
        ShoppingListResource shoppingListResource = shoppinglists.get(shoppingListId);
        ShoppingListOut shoppingListOut = LoopThroughCocktails(shoppingListResource);
        return new ResponseEntity<>(shoppingListOut,HttpStatus.OK);
    }
    /* Part 5 - get all shopping lists */
    @GetMapping(value = "/shopping-listsall", produces = "application/json")
    public ResponseEntity<List<ShoppingListOut>> get() {

        System.out.println("Part 5");
        Set<UUID> keys = shoppinglists.keySet();
        List<ShoppingListOut> shoppingListOuts = new ArrayList<>();

        for(int j=0;j<shoppinglists.size();j++){
            UUID key = (UUID) keys.toArray()[j];
            System.out.println("key > " + key + "  : value = " + shoppinglists.get(key));
            ShoppingListResource shoppingListResource = shoppinglists.get(key);
            ShoppingListOut shoppingListOut = LoopThroughCocktails(shoppingListResource);
            shoppingListOuts.add(shoppingListOut);
        }
        return new ResponseEntity<>(shoppingListOuts,HttpStatus.OK);
    }

    private ShoppingListOut LoopThroughCocktails(ShoppingListResource shoppingListResource){


        List<String> shoppingListIngredients = new ArrayList<>();
        List<CocktailResource> cocktailResourceList = new ArrayList<CocktailResource>();
        CocktailDBResponse response = cocktailDBClient.searchCocktails("Russian");
        for(int i=0;i <response.getDrinks().size();i++){
            CocktailResource singleCocktailResource = new CocktailResource(
                    response.getDrinks().get(i).getIdDrink(),
                    response.getDrinks().get(i).getStrDrink(),
                    response.getDrinks().get(i).getStrGlass(),
                    response.getDrinks().get(i).getStrInstructions(),
                    response.getDrinks().get(i).getStrDrinkThumb(),
                    response.getDrinks().get(i).getIngredientsList());
            cocktailResourceList.add(singleCocktailResource);
        }

        List<CocktailController.CocktailId> cocktailIdList = shoppingListResource.getCocktails();
        ShoppingListOut shoppingListOut = new ShoppingListOut();
        shoppingListOut.setShoppingListId(shoppingListResource.getShoppingListId());
        shoppingListOut.setName(shoppingListResource.getName());
        shoppingListIngredients.clear();
        for (CocktailController.CocktailId cocktailId :cocktailIdList){
            for(CocktailResource cocktailResource : cocktailResourceList)
            {
                System.out.println(cocktailResource.getCocktailId());
                System.out.println(cocktailId.getCocktailId());
                if (cocktailResource.getCocktailId().equals(cocktailId.getCocktailId())) {
                    for(String ingredient : cocktailResource.getIngredients())
                    {
                        shoppingListIngredients.add(ingredient);
                    }
                }
            }
            shoppingListOut.setShoppingListIngredientList(shoppingListIngredients);
        }
        return shoppingListOut;
    }

    public static class ShoppingListOut {

        private UUID shoppingListId;
        private String name;

        List<String> shoppingListIngredient;


        public ShoppingListOut(UUID shoppingListId) {
            this.shoppingListId = shoppingListId;
        }

        public ShoppingListOut() {
        }

        public UUID getShoppingListId() {
            return shoppingListId;
        }

        public void setShoppingListId(UUID shoppingListId) {
            this.shoppingListId = shoppingListId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getShoppingListIngredientList() {
            return shoppingListIngredient;
        }

        public void setShoppingListIngredientList(List<String> shoppingListIngredient) {
            this.shoppingListIngredient = shoppingListIngredient;
        }
    }

    public static class ShoppingListIngredients {
        List<String> shoppingListIngredient;

        public ShoppingListIngredients() {
        }

        public ShoppingListIngredients(List<String> shoppingListIngredient) {
            this.shoppingListIngredient = shoppingListIngredient;
        }

        public List<String> getShoppingListIngredient() {
            return shoppingListIngredient;
        }

        public void setShoppingListIngredient(List<String> shoppingListIngredient) {
            this.shoppingListIngredient = shoppingListIngredient;
        }
    }
}