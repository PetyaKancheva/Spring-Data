package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "volcanologists")
public class Volcanologist extends BaseEntity {
    @Column(name = "first_name", unique = true, nullable = false)
    private String firstName;
    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Double salary;
    @Column(nullable = false)
    private Integer age;
    @Column(name = "exploring_from")
    private LocalDate exploringFrom;
    @ManyToOne
    private Volcano exploringVolcano;


}
