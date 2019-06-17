package prob7b;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary
{
    public static TriFunction<List<Employee>, String, Integer, List<Employee>> filterEmployees = (employeeList, lastNameLowerLimit, salaryLowerLimit) -> {
             return employeeList.stream()
                 .filter(emp->emp.getSalary() > salaryLowerLimit)
                 .filter(emp->emp.getLastName().compareTo(lastNameLowerLimit) > 0)
                 .sorted(Comparator.comparing(Employee::getFirstName)
                     .thenComparing(Employee::getLastName))
                 .collect(Collectors.toList());
             
        };
}
