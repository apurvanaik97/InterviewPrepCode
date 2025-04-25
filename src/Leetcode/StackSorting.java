package Leetcode;

import java.util.Stack;

public class StackSorting {

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(3);
        input.push(4);
        input.push(8);
        input.push(7);

        stackSorting(input);
    }

    private static void stackSorting(Stack<Integer> input) {
        input.forEach(x -> System.out.println("Stack value " + x));


        Stack<Integer> temp = new Stack<>();

        while(!input.isEmpty()){
            int latest = input.pop();
            System.out.println("latest Stack :" + latest);



            while(!temp.isEmpty() && temp.peek() > latest){
                System.out.println("temp Stack :" + temp.peek());
                input.push(temp.pop());
            }
            temp.push(latest);
            temp.forEach(x -> System.out.print("Temp Stack till now " + x));
            System.out.println(" ");
            System.out.println("Input Stack till now ");



            input.forEach(x -> System.out.print(" " + x));
            System.out.println(" ");
        }

        System.out.println("Sorted Stack");
        temp.forEach(x -> System.out.print(" " + x));
    }
}
