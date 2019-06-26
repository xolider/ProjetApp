package projetapp;

public class ModelBuilder {

    private IRotateSprite robot;
    private ISprite bg;

    protected ModelBuilder() {
        buildMap();
        buildRobot();
    }

    private void buildRobot() {
        this.robot = new Robot();
    }

    private void buildMap() {
        this.bg = new Sprite("map.png");
    }

    public IRotateSprite getRobot() {
        return this.robot;
    }

    public ISprite getBg() {
        return this.bg;
    }
}
