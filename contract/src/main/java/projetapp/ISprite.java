package projetapp;

import java.awt.*;
import java.util.Observer;

public interface ISprite {

    int getX();
    int getY();
    Image getImage();
    void loadImage();
    void setX(int x);
    void setY(int y);
    void setObs(Observer obs);
}
