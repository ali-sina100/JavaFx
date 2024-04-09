package ForceSimulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class ForceSimulationTestClass extends Application {
    private Mover mover;

    @Override
    public void start(Stage window) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 800);
        AtomicBoolean applyWind = new AtomicBoolean(false);

        PVector gravity = new PVector(0, 0.1);
        PVector wind = new PVector(0.01, 0);

        pane.setOnMousePressed(e->{
            applyWind.set(true);
        });
        pane.setOnMouseReleased(e->{
            applyWind.set(false);
        });


        pane.setStyle("-fx-background-color: black");
        mover = new Mover(scene.getWidth(), scene.getHeight());
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                mover.applyForce(gravity);
                if(applyWind.get())
                    mover.applyForce(wind);
                mover.update();
                mover.checkEdges();
                mover.display();
            }
        };
        animationTimer.start();

        pane.getChildren().addAll(mover);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
