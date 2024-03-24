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



    @Override
    public void run(String... args) throws Exception {
       // 1. Select Shampoos by Size
//        List<Shampoo> result = shampooService.findAllWithSize(Size.MEDIUM);
        //2. Select Shampoos by Size or Label
        List<Shampoo> result = shampooService.findBySizeOrLabelID(Size.MEDIUM, 10);

        for (Shampoo r:result  ) {
            System.out.println(r);
        }
    }


}

