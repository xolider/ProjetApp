package projetapp;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Robot extends Sprite implements IRotateSprite {

    private Rotation rotation;

    public Robot() {
        super("robot.png", 0, 0);
        this.rotation = Rotation.RIGHT;
    }

    @Override
    public Rotation getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(Rotation rotation) {
        Rotation last = this.rotation;
        this.rotation = rotation;
        this.image = getRotatedImage(last, rotation);
        this.setChanged();
        this.notifyObservers();
    }

    private Image getRotatedImage(Rotation last, Rotation rotation) {
        int degrees = 90;
        switch (last) {
            case RIGHT:
                if(rotation == Rotation.UP) degrees *= -1;
                break;
            case DOWN:
                if(rotation == Rotation.RIGHT) degrees *= -1;
                break;
            case UP:
                if(rotation == Rotation.LEFT) degrees *= -1;
                break;
            case LEFT:
                if(rotation == Rotation.DOWN) degrees *= -1;
                break;
        }

        AffineTransform af = new AffineTransform();
        af.rotate(Math.toRadians(degrees), image.getWidth(null)/2, image.getWidth(null)/2);
        AffineTransformOp afo = new AffineTransformOp(af, AffineTransformOp.TYPE_BILINEAR);
        return afo.filter((BufferedImage)image, null);
    }
}
