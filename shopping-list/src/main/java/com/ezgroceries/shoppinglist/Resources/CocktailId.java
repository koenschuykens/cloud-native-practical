package com.ezgroceries.shoppinglist.Resources;

import java.util.List;
import java.util.UUID;

public class CocktailId {

    private UUID cocktailId;

    /* No args constructor */
    public CocktailId() {
    }

    /* All args constructor */
    public CocktailId(UUID cocktailId) {

        this.cocktailId = cocktailId;

    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }


}