package projetapp;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observer;

public class Frame extends JFrame implements KeyListener {

    private View v;

    private Panel panel;

    public Frame(View v) {
        super("Projet Applicatif");
        this.v = v;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.panel = new Panel(v);
        this.setContentPane(this.panel);
        this.setVisible(true);
        this.addKeyListener(this);
    }

    public Observer getObserver() {
        return this.panel;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        v.getController().orderPerform(keyEvent.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
