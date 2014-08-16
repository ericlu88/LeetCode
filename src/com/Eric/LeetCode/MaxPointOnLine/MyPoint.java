package com.Eric.LeetCode.MaxPointOnLine;

public class MyPoint extends Point
{
    public MyPoint(Point p)
    {
        super(p.x, p.y);
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Point && (obj == this || x == ((Point) obj).x && y == ((Point) obj).y);

    }

    @Override
    public int hashCode()
    {
        return x ^ y;
    }
}
