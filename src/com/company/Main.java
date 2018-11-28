package com.company;

import java.lang.Math;
import java.util.Scanner;

//import static javax.swing.text.html.HTML.Tag.HEAD;

public class Main {

    private static double radius;
    private static double side;
    private static final double pi = 3.14;

    public static void main(String[] args) {

//<<<<<<< HEAD
    //    System.out.println(Calc.Test());

       Word.Word();

//        getArea();


  //      System.out.println("Is my Sqaure is the Circle? Answer: " + isSqInCircle());
  //      System.out.println("Is my Circle is the Sqaure? Answer: " + isCircleinSq());

    }

    public static void getArea() {
//=======
        Task5.Tasks();


//Task5.Tasks();
//                Task4.Word();
        //System.out.println(Calc.Test());

//       getArea();

//            System.out.println("Is my Sqaure is the Circle? Answer: " +isSqInCircle());
//            System.out.println("Is my Circle is the Sqaure? Answer: " +isCircleinSq());

    }

    private static void getArea(){
        System.out.println("Please enter length of the side: ");
//>>>>>>> c4b74de0e2b6367deb79cf342fabce2a2e64a2cf
        Scanner read = new Scanner(System.in);
        double sqArea;
        double crclArea;
        System.out.println("Please enter length of the side: ");

        try {
            side = read.nextDouble();
        } catch (Exception e) {
            System.out.println("Only digits are acceptable!");
        }
//<<<<<<< HEAD
        sqArea = side * side;

        System.out.println(sqArea);
        System.out.println("Please enter circle radius: ");
        try {
            radius = read.nextDouble();
        } catch (Exception e) {
            System.out.println("Only digits are acceptable!");
        }
        crclArea = pi * radius * radius;
        System.out.println(crclArea);
//=======
        sqArea=side*side;
        System.out.println(sqArea);

        System.out.println("Please enter circle radius: ");
        double crclArea;
        try { radius = read.nextDouble();}
        catch (Exception e) {
            System.out.println("Only digits are acceptable!");
        }
        crclArea=pi*radius*radius;
        System.out.println(crclArea);
        //return sqArea;
//>>>>>>> c4b74de0e2b6367deb79cf342fabce2a2e64a2cf
    }

    public static boolean isSqInCircle() {
        return Math.sqrt(2) * side < radius * 2;
    }

    public static boolean isCircleinSq() {
        return radius * 2 < side;

    }
}
