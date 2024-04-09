package MultipleForceSimulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class MultipleObjectForceSimulation extends Application {


    private Pane pane;
    private Scene scene;
    private Mover[] m;
    private PVector gravity;
    private PVector wind;
    private Random random;


    @Override
    public void start(Stage window) throws Exception {

        random = new Random();

        pane = new Pane();
        pane.setPrefSize(1000, 800);

        m = new Mover[200];
        for(int i = 0; i < m.length; i ++) {
            m[i] = new Mover(pane.getPrefWidth(), pane.getPrefHeight());
        }
        wind = new PVector(0.01, 0);



        AnimationTimer animator = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i = 0; i < m.length; i ++) {
                    double mass = m[i].mass;
                    gravity = new PVector(0.0, 0.1*mass);
                    m[i].applyForce(gravity);
                    m[i].applyForce(wind);
                    m[i].update();
                    m[i].checkEdges();
                    m[i].display();
                }
            }
        };
        animator.start();


        pane.getChildren().addAll(m);
        scene = new Scene(pane);
        window.setScene(scene);
        window.show();


    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
