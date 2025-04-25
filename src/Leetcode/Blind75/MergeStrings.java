package Leetcode.Blind75;

public class MergeStrings {
    public static void main(String[] args) {
        MergeStrings mergeStrings = new MergeStrings();
        System.out.println(mergeStrings.mergeAlternately("abc","efghhhhh"));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        if(word1.length() == 0 && word2.length() !=0){
            return word2;
        }

        if(word1.length() != 0 && word2.length() ==0){
            return word1;
        }

        if(word1.length() == 0){
            return "";
        }
        int i =0;
        int j = 0;

        while(i < word1.length() && j < word2.length()){
            result.append(word1.charAt(i));
            i++;
            result.append(word2.charAt(j));
            j++;
        }
        while( i < word1.length()){
            result.append(word1.charAt(i));
            i++;
        }

        while( j < word2.length()){
            result.append(word2.charAt(j));
            j++;
        }
        return result.toString();
    }
}
