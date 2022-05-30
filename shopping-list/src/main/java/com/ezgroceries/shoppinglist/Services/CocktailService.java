package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.repositories.CocktailEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CocktailService {

    // Save operation
    CocktailEntity saveCocktailEntity(CocktailEntity cocktailEntity);

    // Read operation
    List<CocktailEntity> readCocktails(String name);

    /*ShoppingListEntity getShoppingListById(UUID shoppingListId);
    // Update operation
    ShoppingListEntity updateShoppingList(ShoppingListEntity shoppingList,
                                          UUID shoppingListId);

    // Delete operation
    void deleteShoppingListById(UUID shoppingListId);

    ShoppingListIngredients searchShoppingListLogic(UUID uuid);

    ShoppingListEntity addCocktails(UUID uuid, List<CocktailEntity> cocktailIds);*/
}
