package Repeller;

import com.sun.javafx.iio.png.PNGImageLoaderFactory;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;


public class Main extends Application {

    Point2D force = new Point2D(0, 0.2);
    GraphicsContext g;
    Particle p = new Particle();
    ArrayList<Particle> particles = new ArrayList<>();
    Repeller r = new Repeller();


    @Override
    public void start(Stage stage) throws Exception {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                draw();
            }
        };
        animationTimer.start();

        stage.setScene(new Scene(createContent()));
        stage.setTitle("Repeller");
        stage.show();
    }

    private Parent createContent() {

        Pane pane = new Pane();
        pane.setPrefSize(1280, 720);
        Canvas canvas = new Canvas(1280, 720);
        PNGImageLoaderFactory image;
         g = canvas.getGraphicsContext2D();
        pane.getChildren().addAll(canvas);
        pane.setOnMouseDragged(e->{
            r.locate(new Point2D(e.getSceneX(), e.getSceneY()));
        });
        return pane;
    }

    public void draw() {
        g.setGlobalAlpha(1.0);
        g.setGlobalBlendMode(BlendMode.SRC_OVER);
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 1280, 720);
        addParticle();
        run();
    }

    public void addParticle() {

            particles.add(new Particle());

    }
    public void run() {
        Iterator<Particle> it = particles.iterator();

        while (it.hasNext()) {
            Particle p = it.next();
            r.applyForceTo(p);
            r.draw(g);
            p.applyForce(force);
            p.update();

            if(!p.isAlive()){
                it.remove();
                continue;
            }

            p.render(g);
        }

    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}
