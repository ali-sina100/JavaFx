package SimpleHarmonicMotion;




import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class HarmonicMotion extends Application {
    Pane pane;
    private Line line;
    private Circle c1;

    private double period;
    private double amplitude;
    private double frameCount;
    private final double TWO_PI = 6.14;

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

        amplitude = 400;
        period = 120;




        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long l) {

                double x = amplitude * Math.cos(TWO_PI * frameCount / period);
                frameCount ++;

                line.setStartX(x);
                line.setStartY(0);
                c1.setCenterX(x);
                c1.setCenterY(0);


            }
        };
        animationTimer.start();

        pane.getChildren().addAll(line, c1);
        Scene scene = new Scene(pane);
        stage.setTitle("Simple Harmonic Motion");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}

