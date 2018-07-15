package ru.stqa.pft.aufgabe2;

import java.util.Scanner;

public class Aufgabe2 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите координаты первой точки");
        double x1=scan.nextDouble();
        double y1=scan.nextDouble();
        Point p1 = new Point(x1, y1);
        System.out.println("Координаты первой точки равны "+x1+" "+y1);
        System.out.println("Введите координаты второй точки");
        double x2=scan.nextDouble();
        double y2=scan.nextDouble();
        Point p2 = new Point(x2, y2);
        System.out.println("Координаты второй точки равны "+x2+" "+y2);
        System.out.println("Расстояние между двумя данными точками с точностью до сотых равно "+ Math.rint(p1.distance(p2)*100)/100);
    }
/*
    public static double distance(ru.stqa.pft.aufgabe2.Point p1, ru.stqa.pft.aufgabe2.Point p2){
        double sqrX=Math.pow(p1.x-p2.x, 2);
        double sqrY=Math.pow(p1.y-p2.y, 2);
        return Math.sqrt(sqrX+sqrY);
    }
    */
}
