package Leetcode.Blind75;

public class GcdOfStrings {
    public static void main(String[] args) {
        GcdOfStrings gcdOfStrings = new GcdOfStrings();
        String result = gcdOfStrings.gcdOfStrings("ABABAB", "ABABA");

        System.out.println(" GCD = " + result);
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1.concat(str2).equals(str2.concat(str1)))){
            return "";
        }

        int gcdInt = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdInt);

    }

    private static Integer gcd(int a, int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

