package MouseAccelleration;


import java.util.Random;

public class PVector1 {
    public double  x;
    public double y;

    static Random random ;

    public PVector1(double  x, double  y) {
        this.x = x;
        this.y = y;
        random = new Random();
    }

    public void add(PVector1 vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public void sub(PVector1 vector) {
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

    public static PVector1 add(PVector1 v1, PVector1 v2) {
        return new PVector1(v1.x + v2.x, v1.y + v2.y);
    }

    public static PVector1 sub(PVector1 v1, PVector1 v2) {
        return new PVector1(v1.x - v2.x, v1.y - v2.y);
    }

    public static PVector1 mult(PVector1 v1, PVector1 v2) {
        return new PVector1(v1.x * v2.x, v1.y * v2.y);
    }
    public static PVector1 div(PVector1 v1, PVector1 v2) {
        return new PVector1(v1.x / v2.x, v1.y / v2.y);
    }

    public double mag() {
        return Math.sqrt(x*x + y*y);
    }

    public void normalize() {
        double m = mag();
        if(m != 0)
        div(m);
    }

    public void limit(double max) {

        if(x > max)
           x = max;
        else if ( x < -max)
            x = -max;

        if(y > max )
            y = max;
        else if(y < -max)
            y = -max;
    }
    public static PVector1 random2D() {
        return new PVector1(new Random().nextDouble(-1, 1), new Random().nextDouble(-1, 1));

    }
    public String toString() {
        return "\nx : "+this.x + "\ny : " + this.y;
    }
}
