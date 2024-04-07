package bg.softuni.AutoMapping.model;

import jakarta.persistence.*;

@Entity
@Table(name ="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;

}
