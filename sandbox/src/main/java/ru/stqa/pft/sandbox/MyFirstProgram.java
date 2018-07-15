package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("user");
        double len = 5;
        System.out.println("Площадь квадрата со стороной " + len + " равно " + area(len));
        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area(a, b));
    }

    private static void hello(String sb) {
        System.out.println("Hello " + sb + "!");
    }

    private static double area(double l) {
        return l * l;
    }

    private static double area(double a, double b) {
        return a * b;
    }
}