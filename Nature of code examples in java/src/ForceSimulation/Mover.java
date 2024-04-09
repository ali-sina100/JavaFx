package ForceSimulation;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class Mover extends Circle {

    private PVector location;
    private PVector velocity;
    private PVector acceleration;

    private double mass;

    private double width;
    private double height;
    public Mover(double width, double height) {
        this.width = width;
        this.height = height;
        mass = 1;

        location = new PVector(400, 400);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);

        this.setCenterX(location.x);
        this.setCenterY(location.y);
        this.setFill(Color.RED);
        this.setRadius(10);


    }

    public void update() {

        velocity.add(acceleration);
        location.add(velocity);
        acceleration.mult(0);

    }


    public void checkEdges() {
        if(location.x < 0 ) {
            velocity.x *= -1;
            location.x = 0;

        }
        else if(location.x > width){
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
        this.setRadius(mass * 10);
    }

    public void applyForce(PVector force) {
        PVector f = PVector.div(force, mass);
        acceleration.add(f);
    }
}
