package bg.softuni.AdvancedQuerying.repository;

import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository <Shampoo, Long> {

    List<Shampoo> findBySize(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(  Size size, int labelId);
    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc( BigDecimal price);
    int countByPriceLessThan (BigDecimal price);

}
