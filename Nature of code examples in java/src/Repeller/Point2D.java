package Repeller;

public class Point2D {
    double x;
    double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Point2D vector) {
        x += vector.x;
        y += vector.y;
    }
    public void sub(Point2D vector) {
        x -= vector.x;
        y -= vector.y;
    }
    public void mult(double n) {
        x *= n;
        y *= n;
    }
    public void div(double n) {
        x /= n;
        y /= n;
    }
    public static Point2D add(Point2D v1, Point2D v2) {
        return new Point2D(v1.x + v2.x, v1.y + v2.y);
    }
    public static Point2D sub(Point2D v1, Point2D v2) {
        return new Point2D(v1.x - v2.x, v1.y - v2.y);
    }
    public static Point2D div(Point2D v, double n) {
        return  new Point2D(v.x/n, v.y/ n);
    }
    public Point2D get() {
        return new Point2D(x,y);
    }
    public double mag() {
        return Math.sqrt(x*x + y*y);
    }
    public void normalize() {
        double m = mag();
        if(m != 0) {
            div(m);
        }
    }


}


