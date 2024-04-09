package SpiralPath;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Spiral {

    double r = 5;
    double theta = 1;
    double radius = 5;
    double x, y;
    int one, two, three;
    boolean ok = true;
    boolean ok2 = true;
    Random random = new Random();
    public Spiral() {
        x = 0;
        y = 0;
        one = 0;
        two = 0;
        three = 0;
    }

   public void update() {
       r += 0.15 ;
       theta += 0.14;
       x = r * Math.cos(theta);
       y = r * Math.sin(theta);
       if(one < 200 && ok){
           one ++;
       }
       else if(two < 200 && ok) {
           two++;
       }
       else if(three < 200 && ok) {
           three++;
       }
       else {
           ok = false;
           if (ok2){
               two = random.nextInt(100, 230);
           one = random.nextInt(100, 230);
           three = random.nextInt(100, 230);
           ok2 = false;
       }
       }
      if(!ok) {
          if(one > 0){
              one --;
          }
          else if(two > 0){

              two --;
          }
          else if(three > 0) {
              three --;
          }
          else {
              ok = true;
              ok2 = true;
          }
      }
   }

   public void draw(GraphicsContext g) {
       g.fillOval(x, y, radius, radius);
       g.setFill(Color.rgb(one, two, three));
       g.fillOval(500, 500, 10, 10);
   }
}
