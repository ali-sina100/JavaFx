package OscillatorObjects;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Oscillator extends Circle {
    PVector angle;
    PVector velocity;
    PVector amplitude;

    Random random = new Random();

    public Oscillator() {

        angle = new PVector(0, 0);
        velocity = new PVector(random.nextDouble(-0.1, 0.1), random.nextDouble(-0.1, 0.1));
        amplitude = new PVector(random.nextDouble(500), random.nextDouble(500));

        this.setRadius(20);
        this.setFill(Color.ROYALBLUE);

    }

    public void oscillate() {
        angle.add(velocity);
    }

    public void display() {
        double x = Math.sin(angle.x)*amplitude.x;
        double y = Math.sin(angle.y)*amplitude.y;

        this.setCenterX(x);
        this.setCenterY(y);
    }



}
