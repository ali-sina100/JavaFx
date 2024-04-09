package vector;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class forTesting extends Application {

    @Override
    public void start(Stage stage) throws Exception {



        Scene scene = new Scene(new drawVector());
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);

    }

}
