package BouncingBallUsingVectors;


import java.util.Random;

public class PVector {
     public double  x;
     public double y;

    static Random random ;

    public PVector(double  x, double  y) {
        this.x = x;
        this.y = y;
        random = new Random();

    }

    public void add(PVector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public void sub(PVector vector) {
        this.x -= vector.x;
        this.y -= vector.y;
    }
    public void mult(double n) {
        this.x *= n;
        this.y *= n;
    }
    public void div(double n) {
        this.x /= n;
        this.y /= n;
    }

    public void limit(double max) {

        if(x > max || x < -max)
            x = max;
        if(y > max || y < -max)
            y = max;

    }
   public static PVector random2D() {
        return new PVector(new Random().nextDouble(-1, 1), new Random().nextDouble(-1, 1));

    }
    public String toString() {
        return "\nx : "+this.x + "\ny : " + this.y;
    }
}
