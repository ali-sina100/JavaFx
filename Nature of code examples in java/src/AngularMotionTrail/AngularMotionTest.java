package AngularMotionTrail;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class AngularMotionTest extends Application {
    private Pane pane;
    private Line line;
    private Circle c1;

    double r, theta;

    @Override
    public void start(Stage stage) throws Exception {

        pane = new Pane();
        pane.setPrefSize(1000, 1000);
        line = new Line(-150,0,0,0);
        line.setStrokeWidth(2);
        line.setTranslateX(500);
        line.setTranslateY(500);
        line.setStrokeWidth(5);


        c1 = new Circle(50,0,20, Color.RED);
        c1.setTranslateX(500);
        c1.setTranslateY(500);
        c1.setCenterX(line.getStartX());
        c1.setCenterY(line.getStartY());

        r = 200;
        theta = 0;



        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                double x = r * Math.cos(theta);
                double y = r * Math.sin(theta);

                line.setStartX(x);
                line.setStartY(y);
                c1.setCenterX(x);
                c1.setCenterY(y);

                theta += 0.1;

            }
        };
        animationTimer.start();

        pane.getChildren().addAll(line, c1);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}

