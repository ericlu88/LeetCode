package com.Eric.LeetCode.ReverseWordsInAString;

public class Solution {
    public String reverseWords(String s) {
        if (s == null)
            return null;
        String[] wordsArray = s.trim().split(" ");
        if (wordsArray.length == 0)
            return "";
        String reversedWords = "";
        for (int i = 0; i < wordsArray.length; i++ )
        {
            String word = wordsArray[wordsArray.length - i - 1].trim();
            if (word.length() != 0)
                reversedWords +=  word + " ";
        }
        return reversedWords.trim();
    }
}
