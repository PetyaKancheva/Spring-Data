package bg.softuni.AdvancedQuerying.service;

import bg.softuni.AdvancedQuerying.entities.Ingredient;
import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;
import bg.softuni.AdvancedQuerying.repository.IngredientRepository;
import bg.softuni.AdvancedQuerying.repository.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements  IngredientService{

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findByNameStartingWith(String letter) {
        return ingredientRepository.findByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> findByNameIn(List<String> names) {
        return ingredientRepository.findByNameInOrderByPrice( names);
    }

}
