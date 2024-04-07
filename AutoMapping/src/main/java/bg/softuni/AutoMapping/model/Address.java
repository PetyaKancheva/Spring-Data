package bg.softuni.AutoMapping.model;

import jakarta.persistence.*;

@Entity
@Table(name ="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String city;

}
