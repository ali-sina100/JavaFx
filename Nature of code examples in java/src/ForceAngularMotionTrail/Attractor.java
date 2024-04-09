package ForceAngularMotionTrail;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Attractor extends Circle {
    double mass;
    double width, height;
    private  final double G = 100;

    PVector location;

    public Attractor(double width, double height) {
        this.width = width;
        this.height= height;
        this.mass = 1;
        location = new PVector(width/2, height/2);

    }

    public void display() {

        this.setCenterX(location.x);
        this.setCenterY(location.y);
        this.setFill(Color.YELLOW);
        this.setRadius(40);

    }
    public PVector attract(Mover m) {

        PVector force = PVector.sub(location, m.location);
        double distance = force.mag();
        distance = constrain(distance, 5.0, 25);
        force.normalize();
        double strength = (G * mass * m.mass) / (distance * distance);
        force.mult(strength);
        return force;

    }

    private double constrain(double distance, double v, double i) {

        if(distance <v )
            return v;
        else if (distance > i)
            return i;
        else
            return distance;

    }
}

