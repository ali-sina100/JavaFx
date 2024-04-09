package BouncingBallUsingVectors;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TestClassForBouncingBall extends Application {
    private Mover mover;

    @Override
    public void start(Stage window) throws Exception {

        mover = new Mover();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                mover.update();
                mover.checkEdges();
                mover.display();
            }
        };

        animationTimer.start();


        Scene scene = new Scene(mover);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
