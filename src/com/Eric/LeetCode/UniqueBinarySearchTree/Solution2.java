package com.Eric.LeetCode.UniqueBinarySearchTree;

// This is a bad implementation
public class Solution2
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
        for (int i = 1; i <= n; i++)
        {
            allNumbers[i - 1] = -1;
            count += NumOfSubTrees(i, allNumbers, n - 1);
            allNumbers[i - 1] = i;
        }
        return count;
    }

    private int NumOfSubTrees(int root, int[] children, int numOfChildren)
    {
        if (numOfChildren == 2 && root > firstChild(children) && root < lastChild(children))
            return 1;

        if (numOfChildren == 1)
            return 1;

        int count = 0;
        for (Integer child : children)
        {
            if (child < 0)
                continue;
            children[child - 1] = -1;
            numOfChildren--;
            count += NumOfSubTrees(child, children, numOfChildren);
            children[child - 1] = child;
            numOfChildren++;
        }
        return count;
    }

    private int firstChild(int[] children)
    {
        for (int i : children)
        {
            if (i > 0)
                return i;
        }
        return -1;
    }

    private int lastChild(int[] children)
    {
        for (int i = children.length - 1; i >= 0; i-- )
        {
            if (children[i] > 0)
                return children[i];
        }
        return -1;
    }
}
