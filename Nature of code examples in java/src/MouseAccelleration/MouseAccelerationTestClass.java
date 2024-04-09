package MouseAccelleration;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class MouseAccelerationTestClass extends Application {
    private double x = 200, y = 200;
    private Pane pane;
    private Mover1[] mover1 = new Mover1[1500];
    @Override
    public void start(Stage window) throws Exception {
        pane = new Pane();
        pane.setPrefSize(window.getWidth(), window.getHeight());
        for(int i = 0; i < mover1.length; i ++){
            mover1[i] = new Mover1(1900,1000);
        }

       pane.setStyle("-fx-background-color:black");
       pane.setOnMouseMoved(e->{
            x = e.getSceneX();
            y = e.getSceneY();
       });

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                for(int i = 0; i < mover1.length; i ++) {

                    mover1[i].update(x, y);
                    mover1[i].checkEdges();
                    mover1[i].display();

                }
            }
        };


        animationTimer.start();


        pane.getChildren().addAll(mover1);
        Scene scene = new Scene(pane);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
