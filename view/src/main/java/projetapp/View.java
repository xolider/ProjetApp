package projetapp;

public class View implements IView {

    private IModel model;
    private IController controller;
    private Frame frame;

    public View(IModel model) {
        this.model = model;
        this.frame = new Frame(this);
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    public IController getController() {
        return this.controller;
    }

    public IModel getModel() {
        return this.model;
    }
}
