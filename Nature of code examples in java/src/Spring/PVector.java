package Spring;

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
    public static PVector div(PVector v, double n) {
        return  new PVector(v.x/n, v.y/ n);
    }
    public PVector get() {
        return new PVector(x,y);
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


