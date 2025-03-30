package org.example.employeeFileConverter.converters;

import org.example.employeeFileConverter.employee.Employee;

public class CSVConverter implements Converter {
    @Override
    public String getEmployeeFormated(Employee employee) {
        return String.format("%s,%d,%f",
                employee.getName(), employee.getAge(), employee.getSalary()
        );
    }
}
