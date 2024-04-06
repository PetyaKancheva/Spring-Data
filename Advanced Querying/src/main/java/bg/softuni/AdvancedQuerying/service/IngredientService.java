package bg.softuni.AdvancedQuerying.service;

import bg.softuni.AdvancedQuerying.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findByNameStartingWith (String letter);
    List<Ingredient> findByNameIn( List<String> names);
    void increasePriceBy10Percent();
    void deleteByName (String name);
    void updatePriceOfIngredientsByNameList (List <String> names);

}

