package ForceAngularMotionTrail;



import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class ForceAngularTest extends Application {

    private Pane pane;
    private Mover[] m;
    private Attractor attractor;
    Random random;

    @Override
    public void start(Stage stage) throws Exception {
        random = new Random();

        pane = new Pane();
        pane.setStyle("-fx-background-color: black");
        pane.setPrefSize(1800, 1000);

        PVector gravity = new PVector(0, 0);
        attractor = new Attractor(pane.getPrefWidth(), pane.getPrefHeight());
        attractor.display();

        m= new Mover[12];
        for(int i = 0; i < m.length; i ++) {

            m[i] = new Mover(pane.getPrefWidth(), pane.getPrefHeight(), random.nextDouble(0.1, 2));

        }
        AnimationTimer animation = new AnimationTimer() {
            @Override

            public void handle(long l) {
                for(int i = 0; i < m.length; i ++) {

                    PVector f = attractor.attract(m[i]);
                    m[i].applyForce(f);
                    m[i].applyForce(gravity);
                    m[i].update();
                    m[i].display();
                }
            }
        };
        animation.start();


        pane.getChildren().addAll( m);
        pane.getChildren().addAll(attractor);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Friction Simulation");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
