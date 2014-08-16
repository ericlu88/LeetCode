package com.Eric.LeetCode.UniqueBinarySearchTree;

import java.util.Hashtable;

// This is a GOOD implementation!!!
public class Solution3
{
    private Hashtable<Integer, Integer> treeCountMap;

    public int numTrees(int n)
    {
        treeCountMap = new Hashtable<Integer, Integer>();
        treeCountMap.put(1,1);
        treeCountMap.put(2,2);
        treeCountMap.put(3,5);

        for (int i = 4; i <= n; i++)
        {
            int[] numbers = new int[i];
            for (int j = 0; j < i; j++)
                numbers[j] = j + 1;

            int count = countTrees(numbers);

            if (!treeCountMap.containsKey(numbers.length))
                treeCountMap.put(numbers.length, count);
        }

        return treeCountMap.get(n);
    }

    private int countTrees(int[] numbers)
    {
        if (treeCountMap.containsKey(numbers.length))
            return treeCountMap.get(numbers.length);

        int count = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            //int currentRoot = numbers[i];
            int[] leftTreeNumbers = createSubArray(numbers, 0, i - 1);
            int[] rightTreeNumbers = createSubArray(numbers, i + 1, numbers.length - 1);
            int leftTreeCount = leftTreeNumbers == null ? 1 : countTrees(leftTreeNumbers);
            int rightTreeCount = rightTreeNumbers == null ? 1 : countTrees(rightTreeNumbers);
            count += leftTreeCount * rightTreeCount;
        }
        return count;
    }

    private int[] createSubArray(int[] numbers, int startingIndex, int endingIndex)
    {
        if (endingIndex < 0 || startingIndex > numbers.length - 1)
            return null;
        int[] subArray = new int[endingIndex - startingIndex + 1];
        for (int i = startingIndex; i <= endingIndex; i++)
            subArray[i - startingIndex] = numbers[i];
        return subArray;
    }
}
