package bg.softuni.AdvancedQuerying;

import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;
import bg.softuni.AdvancedQuerying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    ShampooService shampooService;

   public Runner (ShampooService shampooService){
        this.shampooService= shampooService;

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


        for (Shampoo r:result  ) {
            System.out.println(r);
        }
    }


}

