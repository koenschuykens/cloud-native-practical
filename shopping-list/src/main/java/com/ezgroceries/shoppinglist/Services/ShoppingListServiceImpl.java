package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.repositories.ShoppingListEntity;
import com.ezgroceries.shoppinglist.repositories.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListServiceImpl implements ShoppingListService{

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Override
    public ShoppingListEntity saveShoppingList(ShoppingListEntity shoppingList)
    {
        return shoppingListRepository.save(shoppingList);
    }

    // Read operation
    /*@Override

    public List<ShoppingListEntity> fetchShoppingListList()
    {
        return (List<ShoppingListEntity>)
                shoppingListRepository.findAll();
    }
    @Override
    public ShoppingListEntity getShoppingListById(UUID shoppingListId)
    {
        return (ShoppingListEntity)
                shoppingListRepository.findById(shoppingListId).get();
    }

    //@Override
    public ShoppingListEntity getCocktails(UUID shoppingListId)
    {
        return (ShoppingListEntity)
                shoppingListRepository.findById(shoppingListId).get();
    }
    // Update operation
    @Override
    public ShoppingListEntity updateShoppingList(ShoppingListEntity shoppingList,UUID shoppingListId)
    {

        return shoppingListRepository.save(shoppingList);
    }

    // Delete operation
    @Override
    public void deleteShoppingListById(UUID shoppingListId)
    {
        shoppingListRepository.deleteById(shoppingListId);
    }
    public ShoppingListEntity addCocktails(UUID uuid, List<CocktailEntity> cocktailIds)
    {
        ShoppingListEntity shoppingList = getShoppingListById(uuid);
        //shoppingList.setCocktails(new HashSet<>(cocktailIds));
        List<CocktailEntity> cocktailList = new ArrayList<>(shoppingList.getCocktails());
        //  Map<String, UUID> result = new HashMap<String,UUID>();
        for(int i=0;i <cocktailIds.size();i++){
            //  System.out.println(shoppingList.getName());
            //  System.out.println(uuid);
            //  System.out.println(shoppingList.getShoppingListID());
            //  System.out.println(cocktailIds.get(i).toString());
            //  System.out.println(cocktailIds.get(i).getCocktailId());
            //cocktailIds.get(i).getCocktailId()
            //shoppingList.getCocktails(i).
            Boolean found = false;
            for(int j=0;j <cocktailList.size();j++) {
                System.out.println(cocktailIds.get(i).getCocktailId().toString());
                System.out.println(cocktailList.get(j).getCocktailId().toString());
                if (cocktailIds.get(i).getCocktailId().toString().equals(cocktailList.get(j).getCocktailId().toString()) ){
                    found = true;
                    break;

                }
            }
            if (found == false)
            {System.out.println(cocktailIds.get(i).getCocktailId() + "added in list");
                shoppingList.getCocktails().add(cocktailIds.get(i));
            }
            else
            { System.out.println(cocktailIds.get(i).getCocktailId() + "already in list");}


        }
        updateShoppingList(shoppingList, uuid);
        return(shoppingList);
    */
    }
