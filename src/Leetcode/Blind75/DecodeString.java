package Leetcode.Blind75;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString decode = new DecodeString();
        decode.decodeString("3[a2[c]]");
    }

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currentStr);
                num = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder decoded = strStack.pop();
                while (repeatTimes-- > 0) {
                    decoded.append(currentStr);
                }
                currentStr = decoded;
            } else {
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}
