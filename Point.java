package com.company.physics;

public class Point {
    protected double x;
    protected double y;
    public Point(double x,double y) {
        this.x=x;
        this.y=y;
    }
    public Point vector(Point head,Point tail) {
        Point vector = null;
       vector.x=tail.x-head.x;
       vector.y=tail.y-head.y;
        return vector;
    }
    public double vector_length(Point vector) {
        double length= (float) Math.sqrt(vector.x*vector.x+vector.y*vector.y);
        return length;
    }
}
