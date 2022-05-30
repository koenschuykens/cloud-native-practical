package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.repositories.ShoppingListEntity;
import org.springframework.stereotype.Service;

public interface ShoppingListService {

    // Save operation
    ShoppingListEntity saveShoppingList(ShoppingListEntity shoppingList);

    // Read operation
    /*List<ShoppingListEntity> fetchShoppingListList();

    ShoppingListEntity getShoppingListById(UUID shoppingListId);
    // Update operation
    ShoppingListEntity updateShoppingList(ShoppingListEntity shoppingList,
                                          UUID shoppingListId);

    // Delete operation
    void deleteShoppingListById(UUID shoppingListId);

    ShoppingListIngredients searchShoppingListLogic(UUID uuid);

    ShoppingListEntity addCocktails(UUID uuid, List<CocktailEntity> cocktailIds);*/
}