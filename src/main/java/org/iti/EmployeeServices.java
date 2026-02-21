package org.iti;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServices {

    public EmployeeServices() {

    }

    public double getMaxSalaryEmployee(List<Employee> myList) {
        return myList.stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary();
    }

    public double getSummationOfSalaries(List<Employee> myList) {
        double sum = 0;
        for (Employee employee : myList) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee getMaxYearsOfExperienceEmployee(List<Employee> myList) {
        return myList.stream().max(Comparator.comparing(Employee::getYearsOfExperience)).get();
    }

    public int getTotalNumberOfEmployees(List<Employee> myList) {
        return myList.size();
    }

    public double getAverageSalaryEmployee(List<Employee> myList) {
        return getSummationOfSalaries(myList) / getTotalNumberOfEmployees(myList);
    }

    public List<String> getAllActiveEmployees(List<Employee> myList) {
        return myList.stream().filter(Employee::isActive).map(Employee::getName).collect(Collectors.toList());
    }


}
