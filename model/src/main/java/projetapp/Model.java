package projetapp;

public class Model implements IModel {

    private ISprite map;

    public Model() {
        buildBackground();
    }

    @Override
    public ISprite getMap() {
        return this.map;
    }

    private void buildBackground() {
        Sprite sprite = new Sprite("map.png");
        this.map = sprite;
    }
}
