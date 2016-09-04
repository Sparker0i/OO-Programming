package org.amrita.oop.shape;

public class Circle implements Shape {
      protected double radius;

     @Override
     public double area() {
          return pi * radius * radius;
     }

     @Override
     public double perimeter() {
          return 2 * pi * radius;
     }
}
