package bg.softuni.AdvancedQuerying.service;

import bg.softuni.AdvancedQuerying.entities.Shampoo;
import bg.softuni.AdvancedQuerying.entities.Size;

import java.util.List;

public interface ShampooService {
    List<Shampoo> findAllWithSize(Size size);

    List<Shampoo> findBySizeOrLabelID(Size size, int LabelId);
}

