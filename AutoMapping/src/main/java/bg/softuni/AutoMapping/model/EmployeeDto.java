package bg.softuni.AutoMapping.model;

public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String salary;

    public EmployeeDto() {
    }

    public EmployeeDto(String firstName, String lastName, String salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public EmployeeDto setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
