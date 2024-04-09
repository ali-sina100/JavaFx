package Repeller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;

public class Repeller {
    Point2D location;
    double mass;
    Point2D force;

    Repeller() {
        mass = 10;
        location = new Point2D(640, 500);


    }

    public void applyForceTo(Particle p) {

        Point2D dir = Point2D.sub(location, p.location);

        dir.normalize();
        double d = dir.mag();
        double force = -1 * 0.25/(d*d*d);
        dir.mult(force);
        p.applyForce(dir);
    }

    public void draw(GraphicsContext g) {
        g.setGlobalAlpha(1.0);
        g.setGlobalBlendMode(BlendMode.SCREEN);
        g.setFill(Color.rgb(250, 50, 40));
        g.fillOval(location.x, location.y, 50, 50);
    }

    public void locate(Point2D p) {
        location =p;
    }


}
