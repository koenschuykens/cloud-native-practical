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

    public CocktailEntity addCocktail(CocktailEntity cocktailEntity)
    {
        return cocktailRepository.save(cocktailEntity);
    }

    public List<CocktailEntity> readCocktail(String name)
    {
        return cocktailRepository.findByNameContainingIgnoreCase(name);
    }
}
