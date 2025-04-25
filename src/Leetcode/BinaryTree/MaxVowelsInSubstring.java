package Leetcode.BinaryTree;

import java.util.Arrays;
import java.util.List;

public class MaxVowelsInSubstring {

    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
    }

    public static int maxVowels(String s, int k) {
        int max = -1;
        boolean[] isVowel = new boolean[128];
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;
        char[] arr = s.toCharArray();
        int currentMax = 0;
        int i;
        for (i = 0; i < k; i++) {
            if (isVowel[arr[i]]) {
                currentMax++;
            }
        }
        max = Math.max(currentMax, max);
        while (true) {
            int length = s.length();
            if (!(i < length)) break;

            if (isVowel[arr[i - k]]) {
                currentMax--;
            }
            if (isVowel[arr[i]]) {
                currentMax++;
            }
            max = Math.max(currentMax, max);
            i++;
        }

        return max;
    }
}

