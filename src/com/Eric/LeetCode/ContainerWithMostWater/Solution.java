package com.Eric.LeetCode.ContainerWithMostWater;

public class Solution
{
    public int maxArea(int[] height)
    {
        if (height == null || height.length == 0)
            return 0;

        int low = 0, high = height.length - 1;
        int maxArea = 0;
        while (low < high)
        {
            maxArea = Math.max(maxArea, (high-low)*Math.min(height[low], height[high]));
            if (height[high] > height[low])
                low++;
            else
                high--;
        }
        return maxArea;
    }
}
