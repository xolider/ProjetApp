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
        g.clearRect(0, 0, 500, 500);
        g.translate((1000/2)-(772/2), (800/2)-(484/2));
        g.drawImage(view.getModel().getMap().getImage(), view.getModel().getMap().getX(), view.getModel().getMap().getY(), null);
    }
}
