package bg.softuni.AutoMapping.service;

import bg.softuni.AutoMapping.model.Employee;
import bg.softuni.AutoMapping.model.EmployeeDto;
import bg.softuni.AutoMapping.model.ManagerDto;

import java.util.List;

public interface EmployeeService {
    Employee create (EmployeeDto employeeDto);
    EmployeeDto findEmployeeByID(Long id);
    List<EmployeeDto> findAllByManagerID(long id);
    ManagerDto createManagerDto(String firstName);


}
