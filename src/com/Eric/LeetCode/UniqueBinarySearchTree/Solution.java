package com.Eric.LeetCode.UniqueBinarySearchTree;

// This is a bad implementation
public class Solution
{
    public int numTrees(int n)
    {
        int count = 0;
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;

        int[] allNumbers = new int[n];
        for (int i = 0; i < n; i++)
            allNumbers[i] = i + 1;
        int maxChild = n;
        int minChild = 1;
        for (int i = 1; i <= n; i++)
        {
            if (i == 1) minChild = 2;
            if (i == n) maxChild = n - 1;
            allNumbers[i - 1] = -1;
            count += NumOfSubTrees(i, allNumbers, n - 1, maxChild, minChild);
            allNumbers[i - 1] = i;
            if (i == 1) minChild = 1;
            if (i == n) maxChild = n;
        }
        return count;
    }

    private int NumOfSubTrees(int root, int[] children, int numOfChildren, int maxChild, int minChild)
    {
        if (numOfChildren == 2 && root > minChild && root < maxChild)
            return 1;

        if (numOfChildren == 1)
            return 1;

        int count = 0;
        for (Integer child : children)
        {
            if (child < 0)
                continue;
            children[child - 1] = -1;
            if (child == minChild)
                count += NumOfSubTrees(child, children, numOfChildren--, findNextSmallest(children, minChild), maxChild);
            else if (child == maxChild)
                count += NumOfSubTrees(child, children, numOfChildren--, minChild, findNextLargest(children, maxChild));
            else
                count += NumOfSubTrees(child, children, numOfChildren--, minChild, maxChild);
            children[child - 1] = child;
        }
        return count;
    }

    private int findNextSmallest(int[] children, int currentMin)
    {
        for (int i = currentMin; i < children.length; i++)
        {
            if (children[i] > 0)
                return children[i];
        }
        return -1;
    }

    private int findNextLargest(int[] children, int currentMax)
    {
        for (int i = currentMax - 2; i >= 0; i--)
        {
            if (children[i] > 0)
                return children[i];
        }
        return -1;
    }
}

