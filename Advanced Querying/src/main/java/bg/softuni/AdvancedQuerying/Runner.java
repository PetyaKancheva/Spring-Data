package bg.softuni.AdvancedQuerying;

import bg.softuni.AdvancedQuerying.entities.Ingredient;
import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;
import bg.softuni.AdvancedQuerying.service.IngredientService;
import bg.softuni.AdvancedQuerying.service.IngredientServiceImpl;
import bg.softuni.AdvancedQuerying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    ShampooService shampooService;
    IngredientService ingredientService;

   public Runner (ShampooService shampooService, IngredientService ingredientService){
        this.shampooService= shampooService;
        this.ingredientService= ingredientService;

    }


    public List<Shampoo> findAllWithSize(Size size) {
        return shampooService.findAllWithSize(size);
    }

    public List<Shampoo> findBySizeOrLabelID(Size size, int LabelId) {
        return shampooService.findBySizeOrLabelID(size, LabelId);
    }

    @Override
    public void run(String... args) throws Exception {
       // 1. Select Shampoos by Size
//        List<Shampoo> result = shampooService.findAllWithSize(Size.MEDIUM);

        //2. Select Shampoos by Size or Label
//        List<Shampoo> result = shampooService.findBySizeOrLabelID(Size.MEDIUM, 10);

        // 3. Select Shampoos by Price
        // higher than a given price. Sort the result descending by
//        List<Shampoo> result =  shampooService.findByPriceGreaterThan( 5.0);
//
//        4. Select Ingredients by Name
//        Create a method that selects all ingredients, which name starts with given letters.
//        List<Ingredient> result = ingredientService.findByNameStartingWith("M");

//        5. Select Ingredients by Names
//        Create a method that selects all ingredients, which are contained in a given list. Sort the result ascending by price.
//        List<Ingredient> result = ingredientService.findByNameIn(List.of("Lavender","Herbs","Apple"));

//        6. Count Shampoos by Price
//        Create a method that counts all shampoos with price lower than a given price.
//        int count = shampooService.countByPriceLowerThan(8.50);
//        System.out.println(count);
//
//        7. Select Shampoos by Ingredients
//        Create a method that selects all shampoos with ingredients included in a given list.
//        List<Shampoo> result =shampooService.findByIngredientsNameIn(List.of("Berry","Mineral-Collagen"));
//        List<Shampoo> result =shampooService.customFindByIngredientsNameIn(List.of("Berry","Mineral-Collagen"));
//
//        8. Select Shampoos by Ingredients Count
//        Create a method that selects all shampoos with ingredients less than a given number.
//        List<Shampoo> result =shampooService.customFindByIngredientsCountLessThan( 2);

//        9. Delete Ingredients by Name
//        Create a method that deletes ingredients by a given name. Use named query.
//        ingredientService.deleteByName("Apple");
//        System.out.println("done");

//        10. Update Ingredients by Price
//        Create a method that increases the price of all ingredients by 10%. Use named query.
//            ingredientService.increasePriceBy10Percent();
//            System.out.println("done");

//        11. Update Ingredients by Names
//       Create a method that updates the price of all ingredients, which names are in a given list.
//            ingredientService.updatePriceOfIngredientsByNameList(List.of("Macadamia Oil","Aloe Vera"));


//        result.forEach(System.out::println);
    }


}

