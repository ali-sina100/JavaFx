package SwingingPendulum;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pendulum extends Circle {
    PVector location;
    PVector origin;
    double r;
    double angle;
    double angleVelocity;
    double aAcceleration;
    double damping;

    Pendulum(PVector origin_, double r_) {
        origin = origin_.get();
        location = new PVector();
        r = r_;
        angle = Math.PI/4;
        angleVelocity = 0;
        aAcceleration = 0;
        damping = 0.995;

        this.setFill(Color.BLACK);
        this.setRadius(40);

    }
    void go() {
        update();
        display();
    }

    void update() {
        double gravity = 0.5;
        aAcceleration =  (-1 * gravity / r) * Math.sin(angle);

        angleVelocity += aAcceleration;
        angle += angleVelocity;

        angleVelocity *= damping;
    }
    void display() {
        location.set(r* Math.sin(angle), r*Math.cos(angle));
        location.add(origin);

        this.setCenterX(location.x);
        this.setCenterY(location.y);

    }
}