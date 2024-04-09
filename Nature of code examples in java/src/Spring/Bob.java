package Spring;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Bob extends Circle {

    PVector location;
    PVector velocity;
    PVector acceleration;

    private double width;
    private double height;

    Random random = new Random();

    public Bob(double width, double height) {
        this.width = width;
        this.height = height;
        this.setFill(Color.BLACK);
        this.setRadius(40);


        location = new PVector(500, 500);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0,0);
    }
    public void update() {

        velocity.add(acceleration);
        location.add(velocity);
        acceleration.mult(0);

    }


    public void display() {
        this.setCenterX(location.x);
        this.setCenterY(location.y);
    }
    public void applyForce(PVector force) {
        acceleration.add(PVector.div(force, 10));
    }

}





