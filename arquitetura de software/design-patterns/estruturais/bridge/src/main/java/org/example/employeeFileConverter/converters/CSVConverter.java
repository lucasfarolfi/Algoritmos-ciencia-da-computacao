package org.example.employeeFileConverter.converters;

import org.example.employeeFileConverter.employee.Employee;

import java.util.Locale;

public class CSVConverter implements Converter {
    @Override
    public String getEmployeeFormated(Employee employee) {
        return String.format(Locale.US,"%s,%d,%f",
                employee.getName(), employee.getAge(), employee.getSalary()
        );
    }
}
