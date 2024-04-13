package softuni.exam.models.entity;


import softuni.exam.models.enums.VolcanoType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="volcanoes")
public class Volcano extends BaseEntity {
    @Column(unique = true,nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer elevation;
    @Enumerated(EnumType.STRING)
    private VolcanoType volcanoType;
    @Column(nullable = false)
    private boolean isActive;
    private LocalDate lastEruption;
    @ManyToOne
    private Country country;


}
