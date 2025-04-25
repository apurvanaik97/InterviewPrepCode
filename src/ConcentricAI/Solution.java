package ConcentricAI;

import java.util.*;

import java.util.Scanner;
class Solution {

    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
//        System.out.println(maxSubArray( new int[]{-2,1,-3,4,-1,2,1,-5}));

        List<String> result = letterCasePermutation("a1b2");
        System.out.println(result);
    }



    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String s, int index, StringBuilder current, List<String> result) {
        // If we've processed all characters in the string, add the current permutation to result
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        char currentChar = s.charAt(index);

        // If the current character is a letter, we have two options: lowercase or uppercase
        if (Character.isLetter(currentChar)) {
            // Option 1: Keep the character in lowercase
            current.append(Character.toLowerCase(currentChar));
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack

            // Option 2: Change the character to uppercase
            current.append(Character.toUpperCase(currentChar));
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        } else {
            // If it's not a letter, just append the character and continue
            current.append(currentChar);
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int currLength = 1, min = Integer.MAX_VALUE, sum = 0, i = 0, j = 0;
        while (i < nums.length && j < nums.length) {

            sum = sum + nums[j];
            if (sum >= target) {
                min = Math.min(min, currLength);
                i++;
                j = i;
                sum = 0;
                currLength = 1;

            } else {
                j++;
                currLength++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;


    }

    public static int maxSubArray(int[] nums) {
        // Initialize current sum and max sum
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Start from the second element
        for (int i = 1; i < nums.length; i++) {
            // If currentSum + nums[i] is less than nums[i], start a new subarray from nums[i]
            int temp = currentSum + nums[i];
            currentSum = Math.max(nums[i], temp);

            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    public static int maxSubArray1(int[] nums) {
        int currentSum = 0;  // Initialize currentSum to 0 (no subarray sum initially)
        int maxSum = Integer.MIN_VALUE;  // Initialize maxSum to a very small value

        for (int num : nums) {
            currentSum += num;  // Add the current number to currentSum

            if (currentSum < 0) {
                currentSum = 0;  // If currentSum becomes negative, reset it to 0 (start a new subarray)
            }

            maxSum = Math.max(maxSum, currentSum);  // Update maxSum if currentSum is greater
        }

        return maxSum;  // Return the maximum subarray sum found
    }
}


//
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        LinkedList list = new LinkedList();
//
//        int N = sc.nextInt();
//        sc.nextLine();
//
//        for (int i = 0; i < N; i++) {
//            String line = sc.nextLine();
//            String[] parts = line.split(" ");
//            String operation = parts[0];
//
//            if (operation.equals("add")) {
//                int value = Integer.parseInt(parts[1]);
//                list.add(value);
//            } else if (operation.equals("remove")) {
//                int value = Integer.parseInt(parts[1]);
//                list.remove(value);
//            } else if (operation.equals("traverse")) {
//                list.traverse();
//            } else if (operation.equals("reverse")) {
//                list.reverse();
//            }
//        }
//
//        sc.close();
//    }
//}
//
//class Node {
//    int data;
//    Node next;
//
//    public Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
//class LinkedList {
//    Node head;
//
//    public LinkedList() {
//        head = null;
//    }
//
//    public void add(int value) {
//        Node newNode = new Node(value);
//        if (head == null) {
//            head = newNode;
//        } else {
//            Node temp = head;
//            while (temp.next != null) {
//                temp = temp.next;
//            }
//            temp.next = newNode;
//        }
//    }
//
//    public void remove(int value) {
//        if (head == null) {
//            return;
//        }
//
//        if (head.data == value) {
//            head = head.next;
//            return;
//        }
//
//        Node temp = head;
//        while (temp.next != null && temp.next.data != value) {
//            temp = temp.next;
//        }
//
//        if (temp.next != null) {
//            temp.next = temp.next.next;
//        }
//    }
//
//    public void traverse() {
//        if (head == null) {
//            System.out.println();
//            return;
//        }
//
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//
//    public void reverse() {
//        Node prev = null;
//        Node current = head;
//        Node next = null;
//
//        while (current != null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        head = prev;
//    }
//}
//
