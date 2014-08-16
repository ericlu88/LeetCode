package com.Eric.LeetCode.MaxPointOnLine;

public class Line
{
    public Double a;
    public Double b;

    public Line(double aa, double bb)
    {
        a = aa;
        b = bb;
    }

    public static Line CalculateLine(Point p1, Point p2)
    {
        double a =  ((double)p1.y - (double)p2.y) != 0.0 && ((double)p1.x - (double)p2.x) != 0.0 ?
                    ((double)p1.y - (double)p2.y) / ((double)p1.x - (double)p2.x)
                    : 0.0;
        double b = ((double)p1.x * (double)p2.y - (double)p2.x * (double)p1.y) != 0.0 && ((double)p1.x - (double)p2.x) != 0.0 ?
                    ((double)p1.x * (double)p2.y - (double)p2.x * (double)p1.y) / ((double)p1.x - (double)p2.x)
                    : 0.0;
        return new Line(a,b);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Line))
            return false;
        if (obj == this)
            return true;

        return  Math.abs(a - ((Line) obj).a) < 1e-10 && Math.abs(b - ((Line) obj).b) < 1e-10;
    }

    @Override
    public int hashCode()
    {
        return a.hashCode() ^ b.hashCode();
    }
}
