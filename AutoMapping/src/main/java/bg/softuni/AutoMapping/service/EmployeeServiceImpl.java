package bg.softuni.AutoMapping.service;

import bg.softuni.AutoMapping.model.Employee;
import bg.softuni.AutoMapping.model.EmployeeDto;
import bg.softuni.AutoMapping.model.ManagerDto;
import bg.softuni.AutoMapping.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto,Employee.class);

        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto findEmployeeByID(Long id) {
        Optional<Employee> employee =employeeRepository.findById( id);
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> findAllByManagerID(long id) {
        //get list of Employees
        List<Employee> employeeList= employeeRepository.findAllByManager_Id(id);
        // map Employees to Employee DTO
        List <EmployeeDto>employeeListDTO = employeeList.stream().map(e-> modelMapper.map(e,EmployeeDto.class)).collect(Collectors.toList());
        return employeeListDTO;
    }

    @Override
    public ManagerDto createManagerDto(String firstName) {
        Employee manager =employeeRepository.findByFirstName(firstName);
        ManagerDto managerDto = new ManagerDto();
        managerDto.setFirstName(manager.getFirstName());
        managerDto.setLastName(manager.getLastName());
        Long managerId= manager.getId();

        managerDto.setEmployees(findAllByManagerID(managerId));
        managerDto.setCount();
        return managerDto;
    }


}
