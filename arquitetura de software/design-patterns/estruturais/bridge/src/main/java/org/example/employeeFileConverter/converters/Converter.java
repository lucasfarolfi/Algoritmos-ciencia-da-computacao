package org.example.employeeFileConverter.converters;

import org.example.employeeFileConverter.employee.Employee;

public interface Converter {
    String getEmployeeFormated(Employee employee);
}
