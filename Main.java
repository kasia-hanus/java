package com.company.physics;

import java.util.Scanner;

public class Main {
    public static Point3D vector_product(Point3D dl, Point3D r_prime) {
       Point3D vectorproduct=new Point3D(dl.y*r_prime.z-dl.z*r_prime.y,-(dl.x*r_prime.z-dl.z*r_prime.x),dl.x*r_prime.y-dl.y*r_prime.x);
       return vectorproduct;
    }
    public static Point3D induction(Point3D dl,Point3D r_prime,double I) {
        double PI = 3.14159265359;
        double mi0= 4 * PI * 0.0000001;
        Point3D vectorprod=vector_product(dl,r_prime);
        double r=r_prime.vector_length(r_prime);
        Point3D B=new Point3D(mi0*I/(4*PI*r*r*r)*vectorprod.x,mi0*I/(4*PI*r*r*r)*vectorprod.y,mi0*I/(4*PI*r*r*r)*vectorprod.z);

        return B;
    }
    public static void induction_integral(Point3D chosen_point,double L, double I,int n)
    {
        Point3D sum=new Point3D(0,0,0);
        double a=-L/2;
        double iterator=(L/2-a)/n;

        while(a<=L/2) {
            Point3D dl=new Point3D(a,0,0);
            Point3D r_prime=new Point3D(chosen_point.x-dl.x,chosen_point.y-dl.y,chosen_point.z-dl.z);
            sum.add(induction(dl,r_prime,I));
            sum.x=sum.x*iterator;
            sum.y=sum.y*iterator;
            sum.z=sum.z*iterator;
            a+=iterator;
        }
        System.out.println(sum);

    }
    public static void main(String[] args) {


        Scanner scan=new Scanner(System.in);
        System.out.println("Insert current");
        double I=scan.nextDouble();
        System.out.println("Insert length of your wire");
        double L=scan.nextDouble();
        System.out.println("Insert coordinates of chosen point");
        Point3D chosen_point= new Point3D(scan.nextDouble(),scan.nextDouble(),scan.nextDouble());
        System.out.println("Insert n");
        int n=scan.nextInt();
        induction_integral(chosen_point,L,I,n);

    }
}
