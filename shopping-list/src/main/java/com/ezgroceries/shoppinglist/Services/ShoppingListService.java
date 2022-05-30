package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.Resources.ShoppingListResource;
import com.ezgroceries.shoppinglist.repositories.ShoppingListRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public ShoppingListResource create(ShoppingListResource shoppingListResource) {

    }
}