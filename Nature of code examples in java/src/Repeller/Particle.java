package Repeller;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import java.util.Random;
public class Particle {

     Point2D location;
    private Point2D velocity;
    private Point2D acceleration;

    private double mass;
    private double lifeSpan;

    private Random random = new Random();


    Particle() {
        location = new Point2D(640, 360);
        velocity = new Point2D(0, 0);
        acceleration = new Point2D(random.nextDouble(-1, 1), 0);
        mass = 1;
        lifeSpan = 1.0;

    }

    public boolean isAlive() {
        return lifeSpan > 0;
    }

    public void update() {
        velocity.add(acceleration);
        location.add(velocity);
        acceleration.mult(0);
        lifeSpan -= 0.02;

    }

    public void render(GraphicsContext g) {
        g.setGlobalAlpha(lifeSpan);
        g.setGlobalBlendMode(BlendMode.SCREEN);
        g.setFill(Color.rgb(250, 50, 40));
        g.fillOval(location.x, location.y, 15, 15);

    }

    public void applyForce(Point2D force) {

        acceleration.add(force);

    }
}
