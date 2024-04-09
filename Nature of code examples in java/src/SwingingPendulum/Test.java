package SwingingPendulum;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Map;

public class Test extends Application {
    Pendulum p;
    Line line = new Line();


    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(1000, 1000);
        p = new Pendulum(new PVector(500, 300), 400);
        line.setStartX(500);
        line.setStartY(300);
        line.endXProperty().bind(p.centerXProperty());
        line.endYProperty().bind(p.centerYProperty());
        line.setFill(Color.RED);

        pane.getChildren().addAll(line, p);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                p.go();
            }
        };
        timer.start();



        stage.setScene(new Scene(pane));
        stage.setTitle("Swinging Pendulum");
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}
