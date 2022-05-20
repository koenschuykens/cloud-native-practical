package com.ezgroceries.shoppinglist.Controller.resources;

import java.util.List;

public class ShoppingListIngredients {
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
