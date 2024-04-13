package softuni.exam.models.entity;


import softuni.exam.models.enums.VolcanoType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="volcanoes")
public class Volcano extends BaseEntity {
    private String name;
    private Long elevation;
    @Enumerated(EnumType.STRING)
    private VolcanoType volcanoType;
    private boolean isActive;
    private LocalDate lastEruption;
    @ManyToOne
    private Country country;


}
