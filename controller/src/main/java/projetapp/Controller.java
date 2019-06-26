package projetapp;

import gnu.io.*;

import java.io.BufferedReader;
import java.util.Enumeration;

public class Controller implements IController {

    private IView view;
    private IModel model;

    private RobotMove robotMove;

    private static final String PORT_NAME = "/dev/ttyACM0";

    public Controller(IView view, IModel model) {
        this.view = view;
        this.model = model;
        this.robotMove = new RobotMove(this.model.getRobot());
    }

    public void start() {
        Enumeration enumeration = CommPortIdentifier.getPortIdentifiers();
        final String PORTS[] = {"/dev/ttyACM0", "COM5"};
        CommPortIdentifier identifier = null;
        SerialPort serialPort = null;
        while(enumeration.hasMoreElements()) {
            identifier = (CommPortIdentifier)enumeration.nextElement();
            System.out.println(identifier.getName());
            for(String str: PORTS) {
                System.out.println(str);
                if(identifier.getName().equals(str)) break;
            }
        }
        try {
            serialPort = (SerialPort)identifier.open(this.getClass().getName(), 2000);
        }
        catch (PortInUseException e) {
            e.printStackTrace();
        }
        while(true) {

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            robotMove.move();
        }
    }

    @Override
    public void orderPerform(char typed) {
        switch (typed) {
            case 'd':
                model.getRobot().setX(model.getRobot().getX()+1);
                break;
            case 's':
                robotMove.turnRight();
                break;
            case 'z':
                robotMove.turnLeft();
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
