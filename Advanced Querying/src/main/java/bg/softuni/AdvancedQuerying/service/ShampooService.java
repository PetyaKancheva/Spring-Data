package bg.softuni.AdvancedQuerying.service;

import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;

import java.util.List;

public interface ShampooService {
    List<Shampoo> findAllWithSize(Size size);

    List<Shampoo> findBySizeOrLabelID(Size size, int LabelId);
    List<Shampoo> findByPriceGreaterThan(Double price);
    int countByPriceLowerThan (Double price);
    List<Shampoo> findByIngredientsNameIn(List<String> ingredientNames);
    List<Shampoo> customFindByIngredientsNameIn(List<String> ingredientNames);

    List<Shampoo> customFindByIngredientsCountLessThan (int count);
}

