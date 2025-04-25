package Misc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DesNumBy {
    public static void main(String[] args) {
        descreaseNumByOne(2);
    }

    public static void descreaseNumByOne(int i) {
        if(i >= 0){
            descreaseNumByOne(i -1);
        }
        System.out.println("Number " + i);
    }
}

interface Show{
    default void show(){
        System.out.println("Default here");
    }

    static void show(int i) {
        System.out.println(i);
    }
}

class Abc implements Show{
    @Override
    public void show() {
        Show.super.show();
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,3,4,5);
        Map<Boolean, List<Integer>> x = input.stream().collect(Collectors.partitioningBy(n -> n%2 ==0));

    }
}
