package Leetcode.Blind75;

public class ReverseVowelsString {

    public static void main(String[] args) {
        ReverseVowelsString reverseVowelsString = new ReverseVowelsString();
        System.out.println(reverseVowelsString.reverseVowels("race a car"));
    }

    public String reverseVowels(String s) {
        int leftptr = 0;
        int rightptr = s.length() -1 ;
        char[] temp = s.toCharArray();
        boolean[] isVowel = new boolean[128];
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;
        isVowel['A'] = true;
        isVowel['E'] = true;
        isVowel['I'] = true;
        isVowel['O'] = true;
        isVowel['U'] = true;

        if(s.length() == 1){
            return s;
        }

        while(leftptr <= rightptr){
            if(!isVowel[temp[leftptr]]){
                leftptr++;
            }
            if(!isVowel[temp[rightptr]]){
                rightptr--;
            }
            if(isVowel[temp[leftptr]] &&isVowel[temp[rightptr]] && leftptr <= rightptr){
                swap(leftptr, rightptr, temp);
                leftptr++;
                rightptr--;
            }
        }
        StringBuilder result = new StringBuilder();
        for(char c : temp){
            result.append(c);
        }
        return result.toString();
    }

    private void swap(int leftptr, int rightptr, char[] temp) {
        char curr = temp[leftptr];
        temp[leftptr] = temp[rightptr];
        temp[rightptr] = curr;
    }
}
