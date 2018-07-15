package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("user");
        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " равно " + area(s));
        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + area(r));
    }

    private static void hello(String sb) {
        System.out.println("Hello " + sb + "!");
    }

    private static double area(Square s) {
        return s.l * s.l;
    }

    private static double area(Rectangle r) {
        return r.a * r.b;
    }
}