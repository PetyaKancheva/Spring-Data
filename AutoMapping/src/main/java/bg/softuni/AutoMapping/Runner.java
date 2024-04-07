package bg.softuni.AutoMapping;

import bg.softuni.AutoMapping.model.EmployeeDto;
import bg.softuni.AutoMapping.model.ManagerDto;
import bg.softuni.AutoMapping.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    private final EmployeeService employeeService;

    public Runner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
//        1. Simple Mapping
        //Create Employee
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter name: ");
//        String firstName= scanner.nextLine();
//        String lastName = "Test";
//        String salary = "1000";
//
//        employeeService.create(new EmployeeDto(firstName,lastName,salary));
//
//        // Map Employee on to DTO

//        EmployeeDto employeeDto =employeeService.findEmployeeByID(1L);

//        System.out.println(employeeDto);

//        2. Advanced Mapping

//         List<EmployeeDto> listOfEmployees = employeeService.findAllByManagerID(11);
//
//         listOfEmployees.forEach(System.out::println);

           ManagerDto managerDTO = employeeService.createManagerDto("Steve");
             System.out.println(managerDTO);
    }
}
