package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("user");
        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " равно " + s.area());
        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());
    }
    private static void hello(String sb) {
        System.out.println("Hello " + sb + "!");
    }


}