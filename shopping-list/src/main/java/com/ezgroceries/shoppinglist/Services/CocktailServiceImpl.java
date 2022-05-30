package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.repositories.CocktailEntity;
import com.ezgroceries.shoppinglist.repositories.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocktailServiceImpl implements CocktailService{

    @Autowired
    private CocktailRepository cocktailRepository;

    // Save operation
    @Override
    public CocktailEntity saveCocktailEntity(CocktailEntity cocktailEntity)
    {
        return cocktailRepository.save(cocktailEntity);
    }

    // Read operation
    public List<CocktailEntity> readCocktails(String name)
    {
        return cocktailRepository.findByNameContainingIgnoreCase(name);
    }

    /*
    // Update operation
    ShoppingListEntity updateShoppingList(ShoppingListEntity shoppingList,
                                          UUID shoppingListId);

    // Delete operation
    void deleteShoppingListById(UUID shoppingListId);

    ShoppingListIngredients searchShoppingListLogic(UUID uuid);

    ShoppingListEntity addCocktails(UUID uuid, List<CocktailEntity> cocktailIds);*/
}
