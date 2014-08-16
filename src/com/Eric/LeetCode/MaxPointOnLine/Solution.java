package com.Eric.LeetCode.MaxPointOnLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;


public class Solution
{
    public static int maxPoints(Point[] points)
    {
        if (points == null || points.length == 0)
            return 0;
        if (points.length == 1)
            return 1;

        // Remove duplicate points, build point map
        Hashtable<MyPoint, Integer> pointMap = new Hashtable<MyPoint, Integer>();
        ArrayList<MyPoint> uniquePoints = new ArrayList<MyPoint>();
        for (int i = 0; i < points.length; i++)
        {
            MyPoint p = new MyPoint(points[i]);
            if (!pointMap.containsKey(p))
            {
                pointMap.put(p, 0);
                uniquePoints.add(p);
            }
            pointMap.put(p, pointMap.get(p) + 1);
        }

        if (uniquePoints.size() == 1)
            return pointMap.get(uniquePoints.get(0));

        Hashtable<Line, Integer> linesCount = new Hashtable<Line, Integer>();
        Hashtable<Line, HashSet<MyPoint>> lines = new Hashtable<Line, HashSet<MyPoint>>();
        for (int i = 0; i < uniquePoints.size(); i++)
        {
            for (int j = i + 1; j < uniquePoints.size(); j++)
            {
                Line l = Line.CalculateLine(uniquePoints.get(i), uniquePoints.get(j));
                if (!lines.containsKey(l))
                {
                    lines.put(l,new HashSet<MyPoint>());
                    linesCount.put(l, 0);
                }
                lines.get(l).addAll(Arrays.asList(uniquePoints.get(i), uniquePoints.get(j)));
                linesCount.put(l, linesCount.get(l) + 1);
            }
        }

        int max = 0;
        Line maxline = null;
        for (Line l: linesCount.keySet())
        {
            int count = linesCount.get(l);
            if (count > max)
            {
                maxline = l;
                max = count;
            }
        }

        int result = (int)((1 + Math.sqrt(1 + 8.0 * max)) / 2);

        for (MyPoint p : lines.get(maxline))
        {
            int samePoint = pointMap.get(p);
            result += samePoint - 1;
        }

        return result;
    }
}
