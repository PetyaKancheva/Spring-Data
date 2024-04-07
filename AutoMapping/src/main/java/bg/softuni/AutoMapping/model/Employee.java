package bg.softuni.AutoMapping.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private BigDecimal salary;
    @Column(nullable = false)
    private LocalDate birthday;
    @ManyToOne
    @Column(nullable = false)
    private Address address;

    public Employee() {
    }

    public Employee(String firstName, String lastName, BigDecimal salary, LocalDate birthday, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Employee setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Employee setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Employee setAddress(Address address) {
        this.address = address;
        return this;
    }
}
