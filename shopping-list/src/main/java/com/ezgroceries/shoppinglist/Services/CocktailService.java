package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.repositories.CocktailEntity;
import java.util.List;

public interface CocktailService {

    CocktailEntity addCocktail(CocktailEntity cocktailEntity);
    List<CocktailEntity> readCocktail(String name);

}
