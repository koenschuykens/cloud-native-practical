create table COCKTAIL_SHOPPING_LIST (
                               SHOPPING_LIST_ID UUID,
                               COCKTAIL_ID UUID,
                               PRIMARY KEY(SHOPPING_LIST_ID,COCKTAIL_ID),
                               FOREIGN KEY (SHOPPING_LIST_ID)
                               REFERENCES SHOPPING_LIST (SHOPPING_LIST_ID),
                               FOREIGN KEY (COCKTAIL_ID)
                               REFERENCES COCKTAIL (COCKTAIL_ID)

);