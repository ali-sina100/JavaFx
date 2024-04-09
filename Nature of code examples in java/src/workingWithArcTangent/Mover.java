package workingWithArcTangent;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Mover extends Rectangle {
    private PVector location;
    private PVector velocity;
    private PVector acceleration;

    private PVector mouse;


    private double w, h, angle ;

    public Mover(double w, double h) {
        this.w = w;
        this.h = h;
        this.setWidth(40);
        this.setHeight(20);
        this.setFill(Color.WHITE);

        location = new PVector(0, 0);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0.1, 0.01);
        mouse = new PVector(0,0);
        angle = 1;

    }
    public void update(Pane pane) {

        pane.setOnMouseMoved(e->{
            mouse.x = e.getSceneX();
            mouse.y = e.getSceneY();
        });

        acceleration = PVector.sub(mouse, location);
        acceleration.normalize();

        velocity.add(acceleration);
        location.add(velocity);
        velocity.limit(10);
        angle += Math.atan2(velocity.x, velocity.y);


    }

    public void checkEdges() {
        if(location.x > w){
            location.x = 0;
        }
        else if(location.x < 0) {
            location.x = w;
        }
        if(location.y > h){
            location.y = 0;
        }
        else if(location.y < 0) {
            location.y = h;
        }
    }

    public void display() {

        this.setX(location.x);
        this.setY(location.y);
        this.setRotate(angle);

    }
}
