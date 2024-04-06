package bg.softuni.AdvancedQuerying.service;

import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;
import bg.softuni.AdvancedQuerying.repository.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements   ShampooService{
    private ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findAllWithSize(Size size) {

        return shampooRepository.findBySize( size);
    }

    @Override
    public List<Shampoo> findBySizeOrLabelID(Size size, int LabelId) {
        return shampooRepository.findBySizeOrLabelIdOrderByPrice( size, LabelId);
    }

    @Override
    public List<Shampoo> findByPriceGreaterThan(Double price) {
        return shampooRepository.findByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(price));
    }

    @Override
    public int countByPriceLowerThan(Double price) {
        return shampooRepository.countByPriceLessThan(BigDecimal.valueOf(price));
    }

    @Override
    public List<Shampoo> findByIngredientsNameIn(List<String> ingredientNames) {
        return shampooRepository.findByIngredientsNameIn(ingredientNames);
    }

    @Override
    public List<Shampoo> customFindByIngredientsNameIn(List<String> ingredientNames) {
        return shampooRepository.customFindByIngredientsNameIn(ingredientNames);
    }

    @Override
    public List<Shampoo> customFindByIngredientsCountLessThan(int count) {
        return shampooRepository.customFindByIngredientsCountLessThan( count);
    }


}
