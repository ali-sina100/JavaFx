package MouseAccelleration;


import javafx.scene.effect.Bloom;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;


public class Mover1 extends Circle {
    double width, height;

    private PVector1 location;
    private PVector1 velocity;
    private PVector1 acceleration;
    private PVector1 mouse;
    private PVector1 dir;


    private  Random random;

    public Mover1(double width, double height) {
        this.width = width;
        this.height = height;
        random = new Random();
        this.setStyle("-fx-background-color: black;");
        location = new PVector1(random.nextDouble(width), random.nextDouble(height));
        velocity = new PVector1(0, 0);
        acceleration = new PVector1(0, 0);
        mouse = new PVector1(0.01, 0.01);

        this.setCenterX(location.x);
        this.setCenterY(location.y);
        this.setRadius(2);
        this.setFill(Color.RED);


    }

    public void update(double x, double y) {

        mouse = new PVector1(x,y);
        dir = PVector1.sub(mouse, location);
        dir.normalize();
        dir.mult(0.5);
        acceleration = dir;
        velocity.add(acceleration);
        location.add(velocity);
        velocity.limit(new Random().nextDouble(100));


    }

    public void display() {
        this.setCenterX(location.x);
        this.setCenterY(location.y);
    }

    public void checkEdges() {
        if (location.x == width) {
            velocity.x *= -1;
        } else if (location.x < 0) {
            velocity.x *= -1;
        }
        if (location.y > height) {
            velocity.y *= -1;
        } else if (location.y < 0) {
            velocity.y *= -1;
        }

    }

}
