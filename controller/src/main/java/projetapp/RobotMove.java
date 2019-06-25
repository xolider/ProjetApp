package projetapp;

public class RobotMove {

    private ISprite robot;

    protected RobotMove(ISprite robot) {
        this.robot = robot;
    }

    protected void move() {
        switch (robot.getRotation()) {
            case RIGHT:
                robot.setX(robot.getX()+1);
                break;
            case DOWN:
                robot.setY(robot.getY()+1);
                break;
            case LEFT:
                robot.setX(robot.getX()-1);
                break;
            case UP:
                robot.setY(robot.getY()-1);
                break;
        }
    }

    protected void turnLeft() {
        switch (robot.getRotation()) {
            case RIGHT:
                robot.setRotation(Rotation.UP);
                break;
            case DOWN:
                robot.setRotation(Rotation.RIGHT);
                break;
            case UP:
                robot.setRotation(Rotation.LEFT);
                break;
            case LEFT:
                robot.setRotation(Rotation.DOWN);
                break;
        }
    }

    protected void turnRight() {
        switch (robot.getRotation()) {
            case RIGHT:
                robot.setRotation(Rotation.DOWN);
                break;
            case DOWN:
                robot.setRotation(Rotation.LEFT);
                break;
            case UP:
                robot.setRotation(Rotation.RIGHT);
                break;
            case LEFT:
                robot.setRotation(Rotation.UP);
                break;
        }
    }
}
