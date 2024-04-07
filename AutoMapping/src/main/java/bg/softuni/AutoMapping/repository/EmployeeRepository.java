package bg.softuni.AutoMapping.repository;

import bg.softuni.AutoMapping.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
//    <Optional>Employee findById(Long id);

    List<Employee> findAllByManager_Id(Long id);

    Employee findByFirstName(String firstName);
}
