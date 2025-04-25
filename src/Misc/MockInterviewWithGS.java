package Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class MockInterviewWithGS {
    public static void main(String[] args) {
        //List<Emloyee> id name salary


        Employee emp = new Employee("ABC", 2302d, 1);
        Employee emp1 = new Employee("BHAVIN", 2301d, 2);
        Employee emp2 = new Employee("MD", 2300d, 3);
        Employee emp3 = new Employee("GS", 2303d, 4);


//        extracted(emp, emp1, emp2, emp3);


        //Write a function to stimulate parallel download from executor file.


        ExecutorService execute = Executors.newFixedThreadPool(40);
        for(int i = 0 ; i < 99; i ++) {
            execute.submit(() -> {

                System.out.println(" Current stream downloading parallely- " + Thread.currentThread().getName());


            });
        }
    }

    private static void extracted(Employee emp, Employee emp1, Employee emp2, Employee emp3) {
        List<Employee> temp = new ArrayList<>(Arrays.asList(emp, emp1, emp2, emp3));

        System.out.println("Current list");

        temp.stream().forEach(System.out::println);

        System.out.println("Updated list list");
        List<Employee> updatedList = temp.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());

        updatedList.forEach(System.out::println);
    }
}
class Employee{
    String name;
    Double salary;
    Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee(String name, Double salary, Integer id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
