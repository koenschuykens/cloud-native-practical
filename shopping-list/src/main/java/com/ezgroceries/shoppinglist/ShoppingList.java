package com.ezgroceries.shoppinglist;

import java.util.UUID;

public class ShoppingList {

    private UUID shoppingListId;
    private String name;

    public ShoppingList(){

    }

    public ShoppingList (UUID shoppingListId, String name){
        this.name = name;
        this.shoppingListId = shoppingListId;
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

}
