package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

public class MoveTowardsPlayerAvoidWalls extends Decision{

    public MoveTowardsPlayerAvoidWalls(String decision){
        super(decision);
    }

    @Override
    public void doAction(DynamicGameObject gameObject, Level level, double dt) {
        double margin = 0.01;
        Vector2D player_location = level.getPlayer().getLocation();
        Vector2D enemy_location = gameObject.getLocation();

        double enemy_x = enemy_location.getX();
        double enemy_y = enemy_location.getY();

        LinkedListNode<Vector2D> path = gameObject.getPath();

        if (path == null) {
            gameObject.setPath(Pathfinding.findPathAvoidWalls(level,enemy_location, player_location));

        } else if (Math.sqrt(Math.pow(path.getValue().getX() - enemy_x, 2) + Math.pow(path.getValue().getY() - enemy_y, 2)) < margin) {
            enemy_location.setX(path.getValue().getX());
            enemy_location.setY(path.getValue().getY());
            gameObject.setPath(path.getNext());

        } else {

            double path_x = path.getValue().getX();
            double path_y = path.getValue().getY();


            if (path_y - enemy_y > margin) {
                gameObject.getVelocity().setY(1.0);
                gameObject.getVelocity().setX(0.0);
            } else if (path_y - enemy_y < -margin) {
                gameObject.getVelocity().setY(-1.0);
                gameObject.getVelocity().setX(0.0);
            } else if (path_x - enemy_x < -margin) {
                gameObject.getVelocity().setX(-1.0);
                gameObject.getVelocity().setY(0.0);
            } else if (path_x - enemy_x > margin) {
                gameObject.getVelocity().setX(1.0);
                gameObject.getVelocity().setY(0.0);
            }
        }
    }
}