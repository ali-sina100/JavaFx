package vector;
public class PVector {
     double  x;
     double y;

     public PVector(double  x, double  y) {
         this.x = x;
         this.y = y;

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
     public String toString() {
         return "\nx : "+this.x + "\ny : " + this.y;
     }
}
