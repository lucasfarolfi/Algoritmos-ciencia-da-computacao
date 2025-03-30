package org.example.employeeFileConverter;

import org.example.employeeFileConverter.converters.CSVConverter;
import org.example.employeeFileConverter.converters.JsonConverter;
import org.example.employeeFileConverter.employee.ITGuy;
import org.example.employeeFileConverter.employee.ProjectManager;

public class Client {
    public static void main(String[] args) {
        var csvConverter = new CSVConverter();
        var jsonConverter = new JsonConverter();

        var itGuy = new ITGuy("Joaozinho Junior", 25, 5000d);
        var pm = new ProjectManager("Diogo Musk", 35, 10000d);

        System.out.println("IT Guy Files");
        System.out.println(csvConverter.getEmployeeFormated(itGuy));
        System.out.println(jsonConverter.getEmployeeFormated(itGuy));

        System.out.println("\nProduct Manager Files");
        System.out.println(csvConverter.getEmployeeFormated(pm));
        System.out.println(jsonConverter.getEmployeeFormated(pm));
    }
}
