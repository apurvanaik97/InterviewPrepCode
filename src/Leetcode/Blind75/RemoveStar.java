package Leetcode.Blind75;

import java.util.Stack;

public class RemoveStar {
    public static void main(String[] args) {
        RemoveStar star = new RemoveStar();
        System.out.println(star.removeStars("leet**cod*e"));
    }
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();


        for(char c : s.toCharArray()){
            if(c == '*') {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}