package com.ezgroceries.shoppinglist.repositories;

import lombok.Data;
import javax.persistence.*;
import java.util.*;
import java.util.List;

@Data
@Entity
@Table(name = "SHOPPING_LIST")
public class ShoppingListEntity {
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    @JoinTable(name = "COCKTAIL_SHOPPING_LIST", joinColumns = @JoinColumn(name = "shopping_list_id"),inverseJoinColumns = @JoinColumn(name = "cocktail_id"))
    private List<CocktailEntity> cocktails;

    @Column(name = "shopping_list_id", nullable = false)
    @Id
    @GeneratedValue
    private UUID shoppingListID;

    @Column(name = "name", nullable = false)
    private String name;

}