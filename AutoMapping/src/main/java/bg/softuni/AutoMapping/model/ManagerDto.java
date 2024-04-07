package bg.softuni.AutoMapping.model;

import java.util.List;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private List<EmployeeDto> employees;
    private Integer count;

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public ManagerDto(String firstName, String lastName, List<EmployeeDto> employees, Integer count) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employees = employees;
        this.count = count;
    }

    public ManagerDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public ManagerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ManagerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ManagerDto setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public ManagerDto setCount() {
        this.count = this.employees.size();
        return this;
    }

    @Override
    public String toString() {

        return firstName + " " + lastName + " | " + "Employees: " + count + "\n" +
                employees;
    }
}
