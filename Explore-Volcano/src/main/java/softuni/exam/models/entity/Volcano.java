package softuni.exam.models.entity;


import lombok.Getter;
import lombok.Setter;
import softuni.exam.models.enums.VolcanoType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "volcanoes")
public class Volcano extends BaseEntity {
    @Column(unique = true, nullable = false)
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
    @OneToMany(mappedBy = "exploringVolcano" ,fetch = FetchType.EAGER)
    private Set<Volcanologist> volcanologists = new HashSet<>();


}
