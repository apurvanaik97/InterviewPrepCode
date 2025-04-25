package Misc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {
        List<Employeee> employees = Arrays.asList(
                new Employeee("Alice", "IT",1000),
                new Employeee("Bob", "HR",2000),
                new Employeee("Charlie", "IT",3000),
                new Employeee("David", "HR",100),
                new Employeee("Eve", "Finance",60000)
        );

        Map<String, List<Employeee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment));

        System.out.println(groupedByDept);


        //get Max salary
        System.out.println("Employee with max salary = " + employees.stream().max(Comparator.comparing(Employeee::getSalary)).get());

        //get Min Salary
        System.out.println("Employee with max salary = "+ employees.stream().min(Comparator.comparing(Employeee::getSalary)).get());


        //Sum of all salary
        System.out.println("Sum of  salary = "+ employees.stream().map(e -> e.salary).reduce(Double::sum).get());


        //Stats
        DoubleSummaryStatistics temp = employees.stream().collect(Collectors.summarizingDouble(e -> e.salary));
        System.out.println("Average  salary = "+ temp.getAverage());
        System.out.println("No. of  salary = "+ temp.getCount());

        //Partioning

        Map<Boolean, List<Employeee> > tempList = employees.stream().collect(Collectors.partitioningBy( employeee -> employeee.salary > 600 ));
        System.out.println("Employees with more than 600 salary = "+ tempList.get(true));

        //Generate function
        Stream.generate( () -> "Test").limit(3).forEach(System.out::println);

        //iterate
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(10) // Limit to 10 elements
                .map(f -> f[0])
                .forEach(System.out::println);

        //Merge
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("D", "E", "F");

        List<String> merged = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());

        System.out.println(merged);


    }
}

class Employeee {
    String name;
    String department;

    double salary;

    Employeee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employeee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
