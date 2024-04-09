package BouncingBallUsingVectors;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Mover extends Pane {
    private PVector location;
    private PVector velocity;
    private PVector acceleration;

    private Circle ball;

    public Mover() {
        this.setStyle("-fx-background-color: black;");
        location = new PVector(200, 200);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);
        ball = new Circle(location.x, location.y, 14, Color.RED);
        this.getChildren().add(ball);
    }

    public void update() {
        acceleration = PVector.random2D();


        velocity.add(acceleration);
        location.add(velocity);
        velocity.limit(5);


    }

    public void display() {
        ball.setCenterX(location.x);
        ball.setCenterY(location.y);
    }

    public void checkEdges() {
        if (location.x > getWidth()) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = getWidth();
        }
        if (location.y > getHeight()) {
            location.y = 0;
        } else if (location.y < 0) {
            location.y = getHeight();
        }

    }

}
