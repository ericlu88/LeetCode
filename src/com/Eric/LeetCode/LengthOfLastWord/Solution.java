package com.Eric.LeetCode.LengthOfLastWord;

public class Solution
{
    public int lengthOfLastWord(String s)
    {
        if (s == null || s.equals(""))
            return 0;

        String[] splits = s.split(" ");
        if (splits.length == 0)
            return 0;

        String lastWord = splits[splits.length-1].trim();
        return lastWord.length();
    }
}
