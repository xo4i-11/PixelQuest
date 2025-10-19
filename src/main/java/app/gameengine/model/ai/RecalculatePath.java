package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

public class RecalculatePath extends Decision {

    public RecalculatePath(String name) {
        super(name);
    }

    @Override
    public void doAction(DynamicGameObject gameObject, Level level, double dt) {
        gameObject.getVelocity().setX(0);
        gameObject.getVelocity().setY(0);

        Vector2D enemy_location=gameObject.getLocation();
        Vector2D player_location=level.getPlayer().getLocation();

        LinkedListNode<Vector2D> path=Pathfinding.findPath(enemy_location,player_location);
        gameObject.setPath(path);
    }
}
