package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name= "countries")
public class Country extends BaseEntity{
@Column(unique = true,nullable = false)
 private String name;
 private String capital;
 @OneToMany(mappedBy ="country", fetch = FetchType.EAGER)
 private Set<Volcano> volcanoes = new HashSet<>();

}
