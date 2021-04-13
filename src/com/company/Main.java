package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args)
    {
        // initialize array of Employees
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing"),
                new Employee("Nobel", "Barnes", 4236.4, "Marketing")};



        // get List view of the Employees
        List<Employee> list = Arrays.asList(employees);

        // display all Employees
        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);   //A method reference.

        // Predicate (boolean-valued function) that returns true for salaries
        //in the range $4000-$6000
        Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        // Display Employees with salaries in the range $4000-$6000
        // sorted into ascending order by salary
        System.out.printf("%nEmployees earning $4000-$6000 per month sorted by salary:%n");

        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        // Display first Employee with salary in the range $4000-$6000
        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                list.stream()
                        .filter(fourToSixThousand)
                        .findFirst()
                        .get());

        // Functions for getting first and last names from an Employee
        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        // Comparator for comparing Employees by first name then last name
        Comparator<Employee> lastThenFirst =
                Comparator.comparing(byLastName).thenComparing(byFirstName);

        // sort employees by last name, then first name
        System.out.printf("%nEmployees in ascending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        // sort employees in descending order by last name, then first name
        System.out.printf("%nEmployees in descending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

        // display unique employee last names sorted
        System.out.printf("%nUnique employee last names:%n");
        list.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // display only first and last names
        System.out.printf("%nEmployee names in order by last name then first name:%n");
        list.stream()
                .sorted(lastThenFirst)
                .map(Employee::getName)
                .forEach(System.out::println);

        // group Employees by department
/*        System.out.printf("%nEmployees by department:%n");
        Map<String, List<Employee>> groupedByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment.forEach(
                (department, employeesInDepartment) ->
                {
                    System.out.println(department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("   %s%n", employee));
                }
        );*/

        // count number of Employees in each department
        System.out.printf("%nCount of Employees by department:%n");

        Map<String, Long> employeeCountByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                TreeMap::new, Collectors.counting()));

        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf("%s has %d employee(s)%n", department, count));



        // sum of Employee salaries with DoubleStream sum method
        System.out.printf(
                "%nSum of Employees' salaries (via sum method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum());

        // calculate sum of Employee salaries with Stream reduce method
        System.out.printf(
                "Sum of Employees' salaries (via reduce method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .reduce(0, (value1, value2) -> value1 + value2));

        // average of Employee salaries with DoubleStream average method
        System.out.printf("Average of Employees' salaries: %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble());

        // Count the number of last names that begin with the letter  ‘B’.
        System.out.printf("%nNumber of Employees' last names that start with 'B': %d%n",
                list.stream()
                    .filter(employee -> employee.getLastName().startsWith("B"))
                    .count());

        // Employee objects whose last name begins with the letter  ‘B’  in sorted order.
        System.out.printf("%nEmployees' last names that start with 'B':, sorted with last name %n");
        list.stream()
                .filter(employee -> employee.getLastName().startsWith("B"))
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        // Employee objects whose last name begins with the letter  ‘B’  and change their first name and last name to be All capital letters.
        System.out.printf("%nEmployees' last names that start with 'B' and change their first name and last name to be All capital letters.:%n");
        ToUpperCase toUpperCase = new ToUpperCase(false);
        list.stream().filter(employee -> employee.getLastName().startsWith("B"))
                .map(toUpperCase::apply)
                .forEach(System.out::println);


        // All Employees capitalize the last letter of those that start with 'B'
        System.out.printf("%nAll Employees, and those whose last names start with 'B' are capitalized:%n");
        ToUpperCase toUpperCase1 = new ToUpperCase(true);
        String emps = list.stream()
                .map(toUpperCase1)
                .collect(Collectors.joining("\n"));
        System.out.println(emps+"\n");

        //Print out all of the Employee objects’ last names, whose last name begins with the letter  ‘I’  in sorted order, and get rid of all the duplicates.
        // Print out only the last names.
        list.stream()
                .filter(employee -> employee.getLastName().startsWith("I"))
                .sorted( Comparator.comparing(Employee::getLastName))
                .map(a -> a.getLastName()).distinct()
                .forEach(System.out::println);

        //Print out the average of all the salaries.
        System.out.printf("%nAverage Salary %.2f",list.stream().mapToDouble(n -> n.getSalary()).average().orElse(0));
//        System.out.printf("Salary %.2f",list.stream().collect(Collectors.averagingDouble(n ->n.getSalary())));
//        System.out.printf("Salary %.2f",list.stream().mapToDouble(n -> n.getSalary()).summaryStatistics().getAverage());


        //Use the  ‘reduce’  method to print out the total salary of all employees.
        System.out.printf("%nTotal Salary %.2f",list.stream().mapToDouble(n -> n.getSalary()).reduce((a,b)->a+b).orElse(0));
//        System.out.printf("%nTotal Salary %.2f",list.stream().mapToDouble(n -> n.getSalary()).summaryStatistics().getSum());
//        System.out.printf("%nTotal Salary %.2f",list.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum());
        System.out.println();


        //Print out only the first names of all the employees.  Use the  ‘map’  method to accomplish this.
        list.stream().map(employee -> employee.getFirstName()).forEach(System.out::println);


        // infinite stream of even numbers (0, 2, 4, …) and then, eventually print out only the first 20 even numbers from this stream
        System.out.println(Stream.iterate(0, a -> a+2).limit(20).collect(Collectors.toList()));
//        System.out.println(Stream.iterate(0,a->a<=20, a -> a+2).limit(20).collect(Collectors.toList()));
    } // end main


/*    public static void startWith(List<Employee> list, String letter) {
        list.stream().filter(employee -> employee.getLastName().startsWith(letter))
                .map(employee -> employee.getLastName().toUpperCase()).forEach(System.out::println);
    }*/

    public int countWords(List<String> words, char c, char d, int len){
        return (int)words.stream().filter(a -> a.length() == len && !a.contains(String.valueOf(d)) && a.contains(String.valueOf(c))).count();
    }
}



/*    TEACH  THE  PEEK()  METHOD

    This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline:

        Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());*/
