package Leetcode.Blind75;

import java.util.Map;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        

        stringCompression.compress(new char[]{'a'});
    }
    public int compress(char[] chars) {
       int index = 0;
        int n = chars.length;
        for(int i = 0; i < n; i ++){
            int count = 0;
            char currentChar = chars[i];

           while(i < n && chars[i] == currentChar){
               count++;
               i++;
           }
           if(count == 1){
               chars[index++] = currentChar;
           }else {
               chars[index++] = currentChar;
               for(char dig : Integer.toString(count).toCharArray()){
                   chars[index++] = dig;
               }
           }
           i--;
       }
       return index;
    }
}
