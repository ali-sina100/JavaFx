package workingWithArcTangent;

public class PVector {
    double x;
    double y;

    public PVector(double x, double y) {
        this.x = x;
        this.y = y;

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
        x *= n;
        y *= n;
    }
    public void div(double n) {
        x /= n;
        y /= n;
    }
    public static PVector add(PVector v1, PVector v2) {
        return new PVector(v1.x + v2.x, v1.y + v2.y);
    }
    public static PVector sub(PVector v1, PVector v2) {
        return new PVector(v1.x - v2.x, v1.y - v2.y);
    }

    public void limit(double n) {
        if(x > n) {
            x = n;
        }
        else if (x < -n) {
            x = -n;
        }
        if(y > n) {
             y = n;
        }
        else if(y < -n) {
            y = -n;
        }
    }

    public double mag() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        double m = mag();
        if (m != 0) {
            div(m);
        }
    }

    public double heading2D(){
        return heading2D();
    }

}
