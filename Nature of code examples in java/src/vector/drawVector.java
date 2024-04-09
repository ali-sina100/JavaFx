package vector;

import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;


public class drawVector extends Pane {

    public drawVector() {
        this.setOnMouseDragged(e->{
            draw(e.getSceneX(), e.getSceneY());
        });

    }

    public void draw(double x, double y) {

        PVector mouse = new PVector(x, y);
        PVector center = new PVector(getWidth() / 2, getHeight() / 2);

        mouse.sub(center);

        Line line = new Line(mouse.x, mouse.y, 0, 0);
        Line line1 = new Line(x, 0, x, getHeight());
        Line line2 = new Line(0, y, getWidth(), y);
        Label label = new Label(x  + " , " + y);
        label.setLayoutX(x +10);
        label.setLayoutY(y-20);

        line.setTranslateX(getWidth()/2);
        line.setTranslateY(getHeight()/2);
        double m = Math.sqrt(mouse.x * getWidth()/2 + mouse.y * getHeight()/2);
        Rectangle rectangle = new Rectangle(0, 0, m, 10);
        this.getChildren().clear();
        this.getChildren().addAll(line, line1, line2, label, rectangle);

    }
}
