package com.ezgroceries.shoppinglist.Resources;

import java.util.List;
import java.util.UUID;

public class CocktailId {

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