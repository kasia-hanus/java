package com.company.physics;

public class Point3D extends Point {
    protected double z;
    public Point3D(double x,double y,double z) {
        super(x, y);
        this.z=z;
    }

    public Point3D vector(Point3D tail,Point3D head) {
        Point3D vector = null;
        vector.x=tail.x-head.x;
        vector.y=tail.y-head.y;
        vector.z=tail.z-head.z;
        return vector;
    }

    public double vector_length(Point3D vector) {
        double length= (float) Math.sqrt(vector.x*vector.x+vector.y*vector.y+vector.z*vector.z);
        return length;
    }
    public  Point3D vector_product(Point3D r_prime) {

         this.x=this.y*r_prime.z-this.z*r_prime.y;
         this.y=-(this.x*r_prime.z-this.z*r_prime.x);
         this.z=this.x*r_prime.y-this.y*r_prime.x;
         Point3D vectorproduct=new Point3D(this.x,this.y,this.z);

         return vectorproduct;
    }
    public Point3D add(Point3D point1) {
        Point3D suma=null;
        this.x+=point1.x;
        this.y+=point1.y;
        this.z+=point1.z;
        return suma;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x + "y=" + y + "z=" + z +
                '}';
    }
}
