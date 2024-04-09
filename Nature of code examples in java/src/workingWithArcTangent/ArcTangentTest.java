package workingWithArcTangent;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ArcTangentTest extends Application {

    private Mover m;

    @Override
    public void start(Stage window) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(1500, 900);
        pane.setStyle("-fx-background-color: black;");

        m = new Mover(pane.getPrefWidth(), pane.getPrefHeight());
        pane.getChildren().addAll(m);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                m.update(pane);
                m.checkEdges();
                m.display();
            }
        };
        timer.start();

        window.setScene(new Scene(pane));
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
