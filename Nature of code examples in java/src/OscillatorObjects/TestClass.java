package OscillatorObjects;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class TestClass extends Application{


    private Oscillator os;
    private Line l;

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        os = new Oscillator();
        pane.getChildren().add(os);
        os.setTranslateX(500);
        os.setTranslateY(500);


        l = new Line();
        l.setTranslateX(500);
        l.setTranslateY(500);
        l.setStartX(0);
        l.setStartY(0);
        l.endXProperty().bind(os.centerXProperty());
        l.endYProperty().bind(os.centerYProperty());

        pane.getChildren().add(l);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                os.oscillate();
                os.display();
            }
        };
        timer.start();

        stage.setScene(new Scene(pane, 1000, 1000));
        stage.setTitle("OscillatorObjects");
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
