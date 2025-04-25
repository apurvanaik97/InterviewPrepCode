package Misc;
import java.util.*;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (char ch : s.toCharArray()) {
            if (map.containsValue(ch)) {
                stack.push(ch); // Opening bracket
            } else if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("([]{})")); // true
        System.out.println(isBalanced("([)]"));   // false
        System.out.println(isBalanced("((("));    // false
    }
}


