package ForceSimulation;

import java.util.Random;

public class PVector {

    double x;
    double y;

    private static Random random;
    public PVector (double x, double y) {
        this.x = x;
        this.y = y;

        random = new Random();
    }

    public void add(PVector vector) {
        x += vector.x;
        y += vector.y;
    }

    public void sub(PVector vector) {
        x -= vector.x;
        y -= vector.y;
    }

    public void mult(double n) {
        x *= x;
        y *= y;
    }

    public void div(double n) {
        x /= n;
        y /= n;
    }

    public static PVector div(PVector v1, double m1) {
        PVector f = new PVector(v1.x / m1, v1.y / m1);
        return f;
    }

    public void limit(double l) {
        if(x > l)
            x = l;
        else if (x < -l)
            x = -1;
        if(y > l)
            y = l;
        else if (y < -l)
            y = -l;
    }

    public double mag() {
        return Math.sqrt(x * x + y * y);
    }
    public void normalize() {
        double m = mag();
        if(m != 0) {
            div(m);
        }
    }
    public static PVector random2D() {
        return new PVector(random.nextDouble(-0.1, 0.1), random.nextDouble(-0.1, 0.1));
    }


}
