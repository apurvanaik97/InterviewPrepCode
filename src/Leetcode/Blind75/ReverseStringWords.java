package Leetcode.Blind75;

public class ReverseStringWords {
    public static void main(String[] args) {
        ReverseStringWords reverseStringWords = new ReverseStringWords();
        String x = reverseStringWords.reverseWords("  hello world  ");
        System.out.println(x);
    }
    public String reverseWords(String s) {
        s = s.replace(" ", "-1");
        String[] x = s.split("-1");
        StringBuilder current = new StringBuilder();
        for(int i = x.length-1 ; i >= 0; i--){
            if(!x[i].equals(""))
            {
                current.append(x[i]);
                current.append(" ");
            }
        }
        return current.substring(0, current.length()-1);
    }
}
