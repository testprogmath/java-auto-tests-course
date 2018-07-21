package ru.stqa.pft.aufgabe3;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.aufgabe2.Point;

public class DistanceTests {
    @Test
    public void TestDistanceInt() {
        Point a = new Point(5, 10);
        Point b = new Point(5, 0);
        a.distance(b);
        Assert.assertEquals(a.distance(b), (double)10);
    }
    @Test
    public void TestDistanceInt2() {
        Point a = new Point(5, 4);
        Point b = new Point(2, 0);
        a.distance(b);
        Assert.assertEquals(a.distance(b), (double)5);
    }
    @Test
    public void TestDistanceDouble() {
        Point a = new Point(78, 4);
        Point b = new Point(2, 0);
        a.distance(b);
        Assert.assertEquals(a.distance(b), Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)));
    }
    @Test
    public void TestDistanceFormuleWithFloat() {
        Point a = new Point(78, 4);
        Point b = new Point(2, 0);
        a.distance(b);
        Assert.assertEquals(a.distance(b), (float)Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)));
    }
    @Test
    public void TestDistanceCompareInt() {
        Point a = new Point(2, 4);
        Point b = new Point(2, 0);
        a.distance(b);
        Assert.assertEquals((int)a.distance(b), (int)Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)));
    }
}
