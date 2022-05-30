package com.ezgroceries.shoppinglist.repositories;

import com.ezgroceries.shoppinglist.Utilities.StringSetConverter;
import lombok.Data;
import javax.persistence.*;
import java.util.*;
@Data
@Entity
@Table(name = "cocktail")
    public class CocktailEntity {
    @Column(name = "cocktail_id", nullable = false)
    @Id
    @GeneratedValue
    private UUID cocktailId;

    @Column(name = "id_drink", nullable = true)
    private String id_drink;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "ingredients", nullable = true)
    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;

}
