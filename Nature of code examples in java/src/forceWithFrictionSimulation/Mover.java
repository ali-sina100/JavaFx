package forceWithFrictionSimulation;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Mover extends Circle {

    private PVector location;
     PVector velocity;
    private PVector acceleration;

    private double width;
    private double height;
    double mass;

    Random random = new Random();

    public Mover(double width, double height, double mass) {
        this.mass = mass;
        this.width = width;
        this.height = height;
        this.setFill(Color.BLUE);
        this.setRadius(7 * mass);


        location = new PVector(random.nextDouble(width), random.nextDouble(height));
        velocity = new PVector(0, 0);
        acceleration = new PVector(0,0);
    }
    public void update() {

        velocity.add(acceleration);
        location.add(velocity);
        acceleration.mult(0);

    }

    public void checkEdges() {

        if(location.x < 0) {
            location.x = 0;
            velocity.x *= -1;
        }
        else if(location.x > width) {
            location.x = width;
            velocity.x *= -1;
        }
        if(location.y < 0) {
            location.y = 0;
            velocity.y *= -1;
        }
        else if(location.y > height) {
            location.y = height;
            velocity.y *= -1;
        }
    }
    public void display() {
        this.setCenterX(location.x);
        this.setCenterY(location.y);
    }
    public void applyForce(PVector force) {
        acceleration.add(PVector.div(force, mass));
    }
}
