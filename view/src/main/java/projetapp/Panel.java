package projetapp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Observable;
import java.util.Observer;

public class Panel extends JPanel implements Observer {

    private View view;

    public Panel(View v) {
        this.view = v;
        System.out.println("init");
    }

    @Override
    public void update(Observable observable, Object o) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.clearRect(0, 0, 1000, 800);
        g.translate((1000/2)-(772/2), (800/2)-(484/2));
        ISprite map = view.getModel().getMap();
        ISprite robot = view.getModel().getRobot();
        g.drawImage(map.getImage(), map.getX(), map.getY(), null);
        g.rotate(robot.getRotation() == Rotation.RIGHT ? 0: robot.getRotation() == Rotation.DOWN ? 1.58 : robot.getRotation() == Rotation.LEFT ?
                3.16 : 4.67);
        g.drawImage(robot.getImage(), (robot.getX()-robot.getImage().getWidth(null)/2), (robot.getY()-robot.getImage().getHeight(null)/2), null);
    }
}
