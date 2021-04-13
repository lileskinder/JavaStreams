package com.company;

import java.util.function.Function;

public class ToUpperCase implements Function<Employee, String> {
    boolean a;

    ToUpperCase(boolean a) {
        this.a = a;
    }

    @Override
    public String apply(Employee employee) {
        if (this.a) {
            if (employee.getLastName().startsWith("B")) {
                return String.format("%-8s %-8s %8.2f   %s",
                        employee.getFirstName(),
                        employee.getLastName().toUpperCase(),
                        employee.getSalary(),
                        employee.getDepartment());

            }
            return employee.toString();
        } else {
            if (employee.getLastName().startsWith("B")) {
                return String.format("%-8s %-8s %8.2f   %s",
                        employee.getFirstName().toUpperCase(),
                        employee.getLastName().toUpperCase(),
                        employee.getSalary(),
                        employee.getDepartment());
            }
            return employee.toString();
        }
    }
}
