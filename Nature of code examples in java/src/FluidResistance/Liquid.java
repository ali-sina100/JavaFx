package FluidResistance;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Liquid extends Rectangle {
    double x, y, w, h;
    double c;


    public Liquid(double x, double y, double w, double h, double c) {

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;

    }

    void display(){

        this.setX(x);
        this.setY(y);
        this.setWidth(w);
        this.setHeight(h);
        this.setFill(Color.BLUE);
        this.setOpacity(0.3);


    }
}
