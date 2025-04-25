package Interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HERETech {
    public static void main(String[] args) {


        Map<String, String> hashMAp = new HashMap<>();
        Map<String, String> hashMap1 = new HashMap<>();



        hashMap1.put("harshal","A");
        hashMap1.put("Ashwin","B");
        hashMap1.put("John","A");
        hashMap1.put("Peter","C");
        hashMap1.put("Simual","B");


        var y = hashMap1.entrySet().stream().collect(Collectors
                .groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        System.out.println(y);
        //harshal -> A
        //Ashwin -> B
        //John -> A
        //Peter -> C
        //Simual -> B

//        hashMAp.put("First Value", "first");
//        hashMAp.put("Second Value", "second");
//        Employee emp1 = new Employee("MD",26,3000d, hashMAp);
//
//        hashMAp.put("Third value","third");


//        System.out.println("Employee OBJ " + emp1);
//        System.out.println("Employee MAP " + emp1.getMapTemp());



        //1 ,  2, 3, 4, 5
        //4, 1 ,  2, 3, 5

        //6 , 1, 2, 3, 4,
        //5, 6 , 1, 2, 3,


        //Class immutable
    }
}

class Employeee {
    final String name;
    final Integer age;
    final Double salary;

    final Map<String, String> mapTemp;


    public Employeee(String name, Integer age, Double salary, Map<String, String> mapTemp) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.mapTemp = mapTemp;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public Map<String, String> getMapTemp(){
        var temp = mapTemp;
        return temp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", mapTemp=" + mapTemp +
                '}';
    }
}
