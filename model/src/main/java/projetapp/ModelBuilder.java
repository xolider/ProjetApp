package projetapp;

public class ModelBuilder {

    private ISprite robot;
    private ISprite bg;

    protected ModelBuilder() {
        buildMap();
        buildRobot();
    }

    private void buildRobot() {
        this.robot = new Sprite("robot.png", 0, 0, Rotation.RIGHT);
    }

    private void buildMap() {
        this.bg = new Sprite("map.png");
    }

    public ISprite getRobot() {
        return this.robot;
    }

    public ISprite getBg() {
        return this.bg;
    }
}
