package projetapp;

public class Main {

    public static void main(String[] args) {
        Model m = new Model();
        View view = new View(m);
        Controller controller = new Controller(view, m);

        view.setController(controller);

        controller.start();
    }
}
