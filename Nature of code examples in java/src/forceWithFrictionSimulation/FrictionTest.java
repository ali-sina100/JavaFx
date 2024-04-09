package forceWithFrictionSimulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class FrictionTest extends Application {

    private Pane pane;
    private Mover[] m;
    Random random;

    @Override
    public void start(Stage stage) throws Exception {

        pane = new Pane();
        pane.setStyle("-fx-background-color: black");
        pane.setPrefSize(1800, 1000);


        m = new Mover[20];
        random = new Random();
        for(int i = 0; i < m.length; i++) {
            m[i] = new Mover(pane.getPrefWidth(), pane.getPrefHeight(),random.nextDouble(1,10));
        }


        PVector wind = new PVector(0.01, 0);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i = 0; i < m.length; i++) {
                    PVector gravity = new PVector(0, 0.1 * m[i].mass);

                    double c = 0.1;
                    PVector friction = m[i].velocity.get();
                    friction.mult(-1);
                    friction.normalize();
                    friction.mult(c);

                    m[i].applyForce(friction);
                    m[i].applyForce(gravity);
                    m[i].applyForce(wind);
                    m[i].update();
                    m[i].checkEdges();
                    m[i].display();
                }
            }
        };
        animationTimer.start();



        pane.getChildren().addAll(m);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Friction Simulation");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
