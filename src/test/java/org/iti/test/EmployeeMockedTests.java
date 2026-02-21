package org.iti.test;

import org.iti.Employee;
import org.iti.EmployeeServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeMockedTests {

    @Mock
    Employee employee1;

    @Mock
    Employee employee2;

    @Mock
    Employee employee3;

    @Mock
    Employee employee4;

    @InjectMocks
    EmployeeServices employeeServices;


    @Test
    public void testGettingActiveEmployees() {
        when(employee1.isActive()).thenReturn(true);
        when(employee1.getName()).thenReturn("Ahmed");

        when(employee2.isActive()).thenReturn(false);

        when(employee3.isActive()).thenReturn(true);
        when(employee3.getName()).thenReturn("Abdelrahman");

        when(employee4.isActive()).thenReturn(true);
        when(employee4.getName()).thenReturn("Mina");


        List<Employee> mockedEmployees = Arrays.asList(employee1, employee2, employee3, employee4);
        assertEquals(List.of("Ahmed", "Abdelrahman", "Mina"), employeeServices.getAllActiveEmployees(mockedEmployees));
    }

    @Test
    public void testGettingMaxSalary() {
        when(employee1.getSalary()).thenReturn(100.0);
        when(employee2.getSalary()).thenReturn(1000.0);
        when(employee3.getSalary()).thenReturn(10000.0);
        when(employee4.getSalary()).thenReturn(100000.0);

        List<Employee> mockedEmployees = Arrays.asList(employee1, employee2, employee3, employee4);
        assertEquals(100000.0, employeeServices.getMaxSalaryEmployee(mockedEmployees));

        assertEquals(111100.0, employeeServices.getSummationOfSalaries(mockedEmployees));
        assertEquals(employeeServices.getSummationOfSalaries(mockedEmployees) / 4, employeeServices.getAverageSalaryEmployee(mockedEmployees));
    }

    @Test
    public void testGettingMaxYearOfExperienceEmployee() {
        when(employee1.getYearsOfExperience()).thenReturn(1);
        when(employee2.getYearsOfExperience()).thenReturn(5);
        when(employee3.getYearsOfExperience()).thenReturn(10);
        when(employee4.getYearsOfExperience()).thenReturn(13);
        when(employee4.getName()).thenReturn("Ali");


        List<Employee> mockedEmployees = Arrays.asList(employee1, employee2, employee3, employee4);
        assertEquals("Ali", employeeServices.getMaxYearsOfExperienceEmployee(mockedEmployees).getName());
    }


}
