package singleParticle;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class TestClass extends Application {
    private GraphicsContext g;
    private Particle particle;

    private int total = 100;

    private ArrayList<Particle> particles;
    private Random random;

    private Pane pane;
    private double x= 500, y=500;



    public void createContent() {
        pane = new Pane();
        pane.setPrefSize(1000, 1000);
        pane.setStyle("-fx-background-color: white");
        Canvas canvas = new Canvas(1000, 1000);
        g = canvas.getGraphicsContext2D();
        pane.getChildren().addAll(canvas);

    }

    public void setup() {
        particles = new ArrayList<>();
        random = new Random();

    }

    public void draw() {

        g.setGlobalAlpha(1.0);
        g.setGlobalBlendMode(BlendMode.SRC_OVER);
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 1000, 1000);

        for(int i = 0; i < 3; i ++)
        particles.add(new Particle(new PVector(x, y)));

        Iterator<Particle> it = particles.iterator();

       while (it.hasNext()) {
           Particle p = it.next();

           if(p.isDead()) {
               it.remove();
               continue;
           }
           p.run(g);
       }
    }


    @Override
    public void start(Stage stage) throws Exception {
        createContent();
        stage.setScene(new Scene(pane));
        setup();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
               draw();
            }
        };
        timer.start();
        pane.setOnMouseDragged(e->{
            x = e.getSceneX();
            y = e.getSceneY();
        });
        stage.setTitle("singleParticle");
        stage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
