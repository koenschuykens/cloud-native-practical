package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.Controller.resources.CocktailId;
import com.ezgroceries.shoppinglist.repositories.CocktailEntity;
import com.ezgroceries.shoppinglist.repositories.ShoppingListEntity;

import java.util.List;
import java.util.UUID;

public interface ShoppingListService {

    ShoppingListEntity addShoppingList(ShoppingListEntity shoppingList);
    ShoppingListEntity readShoppingList(UUID uuid);
    ShoppingListEntity setCocktails(UUID uuid, List<CocktailEntity> cocktailIds);
}