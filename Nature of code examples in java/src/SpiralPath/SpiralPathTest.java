package SpiralPath;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SpiralPathTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Canvas canvas = new Canvas(1000, 1000);

        GraphicsContext g = canvas.getGraphicsContext2D();
        pane.getChildren().add(canvas);
        g.translate(500, 500);
        Spiral spiral = new Spiral();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                spiral.update();
                spiral.draw(g);
            }
        };
        timer.start();




        stage.setScene(new Scene(pane, 1000, 1000));
        stage.setTitle("Spiral Path");
        stage.show();
    }



    public static void main(String[] args) {
        Application.launch(args);
    }

}
