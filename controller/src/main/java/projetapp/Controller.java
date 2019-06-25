package projetapp;

import gnu.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

public class Controller implements IController {

    private IView view;
    private IModel model;

    private static final String PORT_NAME = "/dev/ttyACM0";

    public Controller(IView view, IModel model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        getInput();
    }

    @Override
    public void orderPerform(char typed) {
        switch (typed) {
            case 'q':
                System.exit(0);
                break;
        }
    }

    private BufferedReader getInput() {
        Enumeration en = CommPortIdentifier.getPortIdentifiers();
        while(en.hasMoreElements()) {
            CommPortIdentifier identifier = (CommPortIdentifier)en.nextElement();
            System.out.println(identifier.getName());
        }
        return null;
    }
}
