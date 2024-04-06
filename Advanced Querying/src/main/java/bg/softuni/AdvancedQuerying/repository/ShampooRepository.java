package bg.softuni.AdvancedQuerying.repository;

import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository <Shampoo, Long> {

    List<Shampoo> findBySize(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(  Size size, int labelId);
    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc( BigDecimal price);
    int countByPriceLessThan (BigDecimal price);

    List<Shampoo> findByIngredientsNameIn(List<String> ingredientNames);
    @Query("SELECT s " +
            "FROM Shampoo as s " +
            "JOIN s.ingredients as i " +
            "WHERE i.name IN :ingredientNames ")

    List<Shampoo> customFindByIngredientsNameIn (List<String> ingredientNames );

    @Query("SELECT s " +
            "FROM Shampoo as s " +
            "WHERE size(s.ingredients) < :count"
            )

    List<Shampoo> customFindByIngredientsCountLessThan (int count);

}
