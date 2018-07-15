package ru.stqa.pft.aufgabe2;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        double sqrX = Math.pow(this.x - p2.x, 2);
        double sqrY = Math.pow(this.y - p2.y, 2);
        return Math.sqrt(sqrX + sqrY);
    }
}
