package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

public class TargetingPlayer extends Decision {

    private double distance;

    public TargetingPlayer(String decision_name, double distance) {
        super(decision_name);
        this.distance = distance;
    }

    @Override
    public boolean decide(DynamicGameObject gameObject, Level level, double dt) {
        LinkedListNode<Vector2D> path = gameObject.getPath();

        if (path == null) {
            return false;
        }

        while (path.getNext() != null) {
            path=path.getNext();
        }

        double player_x = level.getPlayer().getLocation().getX();
        double player_y = level.getPlayer().getLocation().getY();

        double gameObject_target_x = path.getValue().getX();
        double gameObject_target_y = path.getValue().getY();

        double distance_to_player = Math.sqrt(Math.pow(player_x - gameObject_target_x, 2) + Math.pow(player_y - gameObject_target_y, 2));

        if (distance_to_player <= this.distance) {
            return true;
        }

        return false;
    }
}