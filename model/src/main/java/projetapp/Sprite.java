package projetapp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Sprite extends Observable implements ISprite {

    private String filename;
    private Image image;
    private int x, y;
    private Rotation rotation;

    public Sprite(String filename) {
        this(filename, 0, 0, Rotation.RIGHT);
    }

    public Sprite(String filename, int x, int y, Rotation rotation) {
        this.filename = filename;
        this.setX(x);
        this.setY(y);
        this.setRotation(rotation);
        this.loadImage();
    }

    @Override
    public void loadImage() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.filename));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void setY(int y) {
        this.y = y;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void setObs(Observer obs) {
        this.addObserver(obs);
    }

    @Override
    public Rotation getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
        this.setChanged();
        this.notifyObservers();
    }
}
