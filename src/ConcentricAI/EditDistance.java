package ConcentricAI;

import java.util.*;

public class EditDistance {

    public static int updateWord(List<String> words, String startWord, String endWord) {
        // your code goes here
        int startIndex = -1;
        int endIndex = -1;
        for(int i = 0; i < words.size(); i++){
            if(startWord.equals(words.get(i))){
                startIndex = i;
            }
            if(endWord.equals(words.get(i))){
                endIndex = i;
            }
        }
        if(startIndex != -1 && endIndex != -1 ){
            return Math.abs(startIndex - endIndex);
        }
        return -1;
    }

    public static void main(String[] args) {
        // debug your code below
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hit", "hot", "dot", "dog", "cog");

        System.out.println(EditDistance.updateWord(wordList, beginWord, endWord));
    }
}