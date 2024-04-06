package bg.softuni.AdvancedQuerying.service;

import bg.softuni.AdvancedQuerying.entities.Ingredient;
import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findByNameStartingWith (String letter);
    List<Ingredient> findByNameIn( List<String> names);

}

