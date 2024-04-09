package Spring;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Spring extends Line {

    PVector anchor;
    double length;
    double k = 0.015;

    public Spring(double x, double y, double l) {

        anchor = new PVector(x,y);
        this.length = l;
        this.setStartX(x);
        this.setStartY(y);

    }

    public void connect(Bob b) {
        PVector force = PVector.sub(b.location, anchor);
        double d = force.mag();
        double stretch = d-length;

        force.normalize();
        force.mult(-1 * k * stretch);
        b.applyForce(force);
    }

    public void displayLine(Bob b) {

        this.setFill(Color.BLUE);
        this.setStrokeWidth(3);
        this.setStartX(b.location.x);
        this.setStartY(b.location.y);
        this.setEndX(500);
        this.setEndY(500);

    }
}
