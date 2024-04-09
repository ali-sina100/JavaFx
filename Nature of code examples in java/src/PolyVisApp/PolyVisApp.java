package PolyVisApp;

import com.sun.scenario.animation.shared.AnimationAccessor;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class PolyVisApp extends Application {
    private static final int W = 1280;
    private static final int H = 720;
    private static final double PIXELS_PER_UNIT = 40.0;
    private static final double DURATION = 2.50;
    private double t = 0.0;

    private GraphicsContext g;

    private List<FunctionData> functions = Arrays.asList(
            new FunctionData(Color.BLACK, x -> x),
            new FunctionData(Color.RED, x -> x * x),
            new FunctionData(Color.BROWN, x-> Math.sin(x))
    );


    @Override
    public void start(Stage stage) throws Exception {


        stage.setScene(new Scene(createContent()));
        stage.setTitle("Functions Visualization App");
        stage.show();

    }

    private Parent createContent() {

        Pane root = new Pane();
        root.setPrefSize(W, H);

        Canvas canvas = new Canvas(W, H);
        g = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                OnUpdate();
                t += 0.016;
                if(t > DURATION)
                    t=0;
            }
        };
        timer.start();

        root.getChildren().addAll(canvas);
        return root;

    }

    private void OnUpdate() {
        g.clearRect(0, 0, W, H);


        functions.forEach(f ->{
            g.setStroke(f.color);
            g.setLineWidth(2);

            int maxDrawX = (int) (W * t /DURATION);
            int startDrawX = maxDrawX >= 50 ? maxDrawX - 50 : 0;
            for(int drawX = startDrawX ; drawX < maxDrawX; drawX ++) {
                double x = (drawX - W/2) / PIXELS_PER_UNIT;
                double y = f.function.apply(x);
                double drawY =  H - (y  * PIXELS_PER_UNIT + H / 2) ;
                g.strokeLine(f.oldX, f.oldY, drawX, drawY);
                f.oldX = drawX;
                f.oldY = drawY;
            }

            f.oldX = 0;
            f.oldY = 0;
        });
    }

    private static class FunctionData {
        private Color color;
        private Function<Double, Double> function;
        private double oldX = 0.0;
        private double oldY = 0.0;

        public FunctionData(Color color, Function<Double, Double> function) {
            this.color = color;
            this.function = function;
        }
    }


    public static void main(String[] args) {

        Application.launch(args);
    }
}
