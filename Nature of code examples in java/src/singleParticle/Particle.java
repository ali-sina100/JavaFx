package singleParticle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import java.io.File;
import java.util.Random;

public class Particle{
    private PVector location;
    private PVector velocity;
    private Random random;
    private double lifeSpan;
    private static File file = new File("C:\\java projects\\forPractice\\src\\singleParticle\\fire.png");


    private double w, h;
    public Particle(PVector l) {
        random = new Random();
        this.location = l.get();

        this.velocity = new PVector(random.nextDouble(-0.3, 0.3), random.nextDouble(-2, 0));

        lifeSpan = 1;

    }
    public void run(GraphicsContext g) {
        update();
        display(g);
    }

    public void update() {
        location.add(velocity);
        lifeSpan -= 0.009;

    }

    public void display(GraphicsContext g) {

        g.setGlobalAlpha(lifeSpan);
        g.setGlobalBlendMode(BlendMode.SCREEN);
        g.setFill(Color.rgb(250, 50, 40));
       // g.drawImage(new Image(String.valueOf(file)), location.x, location.y, 15, 15);
        g.fillOval(location.x, location.y, 10,10);


    }

    public boolean isDead () {
        return lifeSpan < 0;
    }

    public void setLocation(double x, double y) {
        location.x = x;
        location.y = y;
    }
}
