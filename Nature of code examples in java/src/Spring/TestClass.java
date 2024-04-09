package Spring;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestClass extends Application {


    private Bob bob;
    private Spring spring;
    private Pane pane;
    private PVector gravity;

    @Override
    public void start(Stage stage) throws Exception {
        pane = new Pane();
        pane.setPrefSize(1000, 1000);
        bob = new Bob(pane.getPrefWidth(), pane.getPrefHeight());
        spring = new Spring(500, 500, 70);
        pane.getChildren().addAll(bob, spring);
        gravity = new PVector(0.0, 1);



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                draw();
            }
        };

        timer.start();

        stage.setScene(new Scene(pane));
        stage.setTitle("Spring");
        stage.show();

    }
    public void draw() {

        bob.applyForce(gravity);
        spring.connect(bob);
        bob.update();
        bob.display();
        spring.displayLine(bob);

    }

    public static void main(String[] args) {
            Application.launch(args);
    }



}
