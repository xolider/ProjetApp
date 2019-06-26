package projetapp;

public class Model implements IModel {

    private ModelBuilder builder;

    public Model() {
        builder = new ModelBuilder();
    }

    @Override
    public ISprite getMap() {
        return this.builder.getBg();
    }

    @Override
    public IRotateSprite getRobot() {
        return this.builder.getRobot();
    }
}
